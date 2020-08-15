package com.leo9.dc38.kruskal_algorithm;

import java.util.Arrays;

public class KruskalAlgorithm {
    //定义边的数量
    private int side_num;
    //定义顶点值的数组
    private char[] vertex_data;
    //定义邻接矩阵
    private int[][] graph_matrix;
    //使用Integer的最大值来表示两点不连通, 即类似无穷远距离
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex_data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] graph_matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};

        KruskalAlgorithm algorithm_case = new KruskalAlgorithm(vertex_data, graph_matrix);
        algorithm_case.showMatrix();
        SideData[] mst_res = algorithm_case.getMST();
        System.out.println("\n============show the MST=============");
        showSide(mst_res);

    }

    //定义构造函数
    public KruskalAlgorithm(char[] vertex_data, int[][] graph_matrix) {
        //定义变量获取顶点数
        int vertex_num = vertex_data.length;

        //初始化顶点, 采用值传递的方式
        this.vertex_data = new char[vertex_num];
        for (int i = 0; i < vertex_num; i++) {
            this.vertex_data[i] = vertex_data[i];
        }

        //初始化边, 依然采用值传递方式
        this.graph_matrix = new int[vertex_num][vertex_num];
        for (int i = 0; i < vertex_num; i++) {
            for (int j = 0; j < vertex_num; j++) {
                this.graph_matrix[i][j] = graph_matrix[i][j];
            }
        }

        //统计边的数量, 因为是无向图, 获取一半的边就可以了
        for (int i = 0; i < vertex_num; i++) {
            for (int j = i + 1; j < vertex_num; j++) {
                if (graph_matrix[i][j] != INF) {
                    side_num++;
                }
            }
        }
    }

    //定义显示矩阵的方法
    public void showMatrix() {
        System.out.println("\n==========show matrix===========");
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                System.out.printf("%6c    ", 'A' + i);
            } else {
                System.out.printf("%-5c", 'A' + i);
            }
        }
        System.out.println();
        int index = 0;
        for (int[] row : graph_matrix) {
            System.out.printf("%-5c", 'A' + index);
            index++;
            for (int data : row) {
                if (data == INF) {
                    System.out.printf("%-5s", "INF");
                } else {
                    System.out.printf("%-5d", data);
                }

            }
            System.out.println();
        }
    }

    //定义方法对边进行排序, 传入的是边的集合
    private static void sortSide(SideData[] sides) {
        for (int i = 0; i < sides.length; i++) {
            for (int j = 0; j < sides.length - 1 - i; j++) {
                if (sides[j].side_weight > sides[j + 1].side_weight) {
                    SideData tmp = sides[j];
                    sides[j] = sides[j + 1];
                    sides[j + 1] = tmp;
                }
            }
        }
    }

    private static void showSide(SideData[] sides) {
        int count = 0;
        for (int i = 0; i < sides.length; i++) {
            System.out.printf("%-15s", sides[i]);
            count++;
            if (count == 3) {
                System.out.println();
                count = 0;
            }
        }
    }

    //定义方法返回传入顶点的下标, 找到则返回数组下标, 否则返回-1.
    private int getPosition(char vertex) {
        for (int i = 0; i < vertex_data.length; i++) {
            if (vertex_data[i] == vertex) {
                return i;
            }
        }
        return -1;
    }

    //定义方法获取图中的边, 放到边数组当中, 后续需要遍历该数组
    private SideData[] getSides() {
        //定义一个索引来给边数组遍历时进行使用
        int index = 0;
        //定义边数组
        SideData[] sides = new SideData[side_num];
        //循环遍历邻接矩阵, 获取边, 也是获取一半的就可以了
        for (int i = 0; i < vertex_data.length; i++) {
            for (int j = i + 1; j < vertex_data.length; j++) {
                if (graph_matrix[i][j] != INF) {
                    sides[index++] = new SideData(vertex_data[i], vertex_data[j], graph_matrix[i][j]);
                }
            }
        }
        return sides;
    }

    //定义方法获取下标为 i 的顶点的终点
    //用于后面进行判断两个顶点的终点是否相同而形成回路
    //ends[]数组是记录下标为 i 的顶点所对应的终点, 顶点数组和ends[]数组共用一套下标
    private int getVertexEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    private SideData[] getMST() {
        //表示最终结果数组的索引
        int index = 0;
        //用于保存已有最小生成树中的每个顶点在最小生成树中的终点
        int[] ends = new int[side_num];
        //创建最终结果数组. 用于保存最小生成树.
        SideData[] mst_res = new SideData[vertex_data.length - 1];
        //获取图中所有边的集合, 并从小到大排序
        SideData[] sides = getSides();
        sortSide(sides);
        //输出当前图的边的集合
        System.out.println("\n============show graph's sides============");
        showSide(sides);

        //开始遍历边集合sides, 进行逐步构造最小生成树并判断即将加入的边是否构成回路
        for (int i = 0; i < side_num; i++) {
            //获取到第i条边的第一个顶点, 即边的起点
            int p1 = getPosition(sides[i].start_point);
            //获取到第i条边的第二个顶点, 即边的终点
            int p2 = getPosition(sides[i].end_point);

            //获取p1,p2两个顶点在已有的最小生成树中的终点
            int end_p1 = getVertexEnd(ends, p1);
            int end_p2 = getVertexEnd(ends, p2);

            //判断是否会构成回路
            if(end_p1 != end_p2){
                //如果没有构成回路, 则设置p1的终点为p2
                ends[end_p1] = end_p2;
                //同时将这条边加入最小生成树当中
                mst_res[index++] = sides[i];
            }
        }
        //最终返回最小生成树集合
        return mst_res;
    }
}
