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
    }

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

        //统计边的数量
        for (int i = 0; i < vertex_num; i++) {
            for (int j = 0; j < vertex_num; j++) {
                if (graph_matrix[i][j] != INF) {
                    side_num++;
                }
            }
        }
    }

    public void showMatrix() {
        System.out.println("==========show matrix===========");
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                System.out.printf("%10c", 'A' + i);
            } else {
                System.out.printf("%5c", 'A' + i);
            }
        }
        System.out.println();
        int index = 0;
        for (int[] row : graph_matrix) {
            System.out.printf("%5c", 'A' + index);
            index++;
            for (int data : row) {
                if (data == INF) {
                    System.out.printf("%5s", "INF");
                } else {
                    System.out.printf("%5d", data);
                }

            }
            System.out.println();
        }
    }
}
