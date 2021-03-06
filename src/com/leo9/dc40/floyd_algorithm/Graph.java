package com.leo9.dc40.floyd_algorithm;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Graph {
    //存放顶点的数组
    private char[] vertex_data;
    //存放从各个顶点出发到其它顶点的距离, 最后结果也直接写入其中.
    private int[][] vertex_route;
    //存放到达目标顶点的前驱结点
    private int[][] vertex_pre;

    public Graph(char[] vertex_data, int[][] vertex_route) {
        //给顶点数组和距离矩阵赋值
        this.vertex_data = vertex_data;
        this.vertex_route = vertex_route;
        //初始化前驱结点数组
        this.vertex_pre = new int[vertex_data.length][vertex_data.length];
        for (int i = 0; i < vertex_data.length; i++) {
            Arrays.fill(vertex_pre[i], i);
        }
    }

    //实现弗洛伊德算法
    public void getRouteByFloydAlgorithm() {
        //定义临时变量保存最短路径
        int temp_route = 0;
        //开始三层循环, 第一层循环选的是中间顶点
        for (int k = 0; k < vertex_route.length; k++) {
            //第二层循环选的是出发顶点
            for (int i = 0; i < vertex_route.length; i++) {
                //第三层选择的是结束顶点
                for (int j = 0; j < vertex_route.length; j++) {
                    //获取顶点经过中间点再到终点的路径长度, 并赋给临时路径
                    temp_route = vertex_route[i][k] + vertex_route[k][j];
                    //然后用临时路径和起点到终点直连的路径比较
                    if (temp_route < vertex_route[i][j]) {
                        //如果临时路径比直连路径小, 则将直连路径重置为最小的临时路径
                        vertex_route[i][j] = temp_route;
                        //同时更新前驱结点
                        vertex_pre[i][j] = vertex_pre[k][j];
                    }
                }
            }
        }
    }


    //定义方法, 显示距离矩阵和前驱结点数组
    public void showArray() {
        System.out.println("===========show route matrix===========");
        for (int j = 0; j <= vertex_data.length; j++) {
            if (j - 1 < 0) {
                System.out.printf("%4c", ' ');
            } else {
                System.out.printf("%4c", vertex_data[j - 1]);
            }
        }
        System.out.println();
        //打印距离矩阵
        for (int i = 0; i < vertex_route.length; i++) {
            System.out.printf("%-3c[", 'A' + i);
            for (int j = 0; j < vertex_route.length; j++) {
                if (vertex_route[i][j] == 65535) {
                    System.out.printf("%4c", 'N');
                } else {
                    System.out.printf("%4d", vertex_route[i][j]);
                }
            }
            System.out.printf("   ]\n");
        }

        System.out.println();

        System.out.println("===========show pre matrix===========");
        for (int j = 0; j <= vertex_data.length; j++) {
            if (j - 1 < 0) {
                System.out.printf("%4c", ' ');
            } else {
                System.out.printf("%4c", vertex_data[j - 1]);
            }
        }
        System.out.println();
        //打印前驱结点矩阵
        for (int i = 0; i < vertex_pre.length; i++) {
            System.out.printf("%-3c[", 'A' + i);
            for (int j = 0; j < vertex_pre.length; j++) {
                System.out.printf("%4d", vertex_pre[i][j]);
            }
            System.out.printf("   ]\n");
        }
    }
}
