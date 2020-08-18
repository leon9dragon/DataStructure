package com.leo9.dc39.dijkstra_algorithm;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        //定义顶点数组
        char[] vertex_data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //定义邻接矩阵
        int[][] graph_matrix = new int[vertex_data.length][vertex_data.length];
        //定义最大值常量
        final int N = 65535;
        //初始化邻接矩阵
        graph_matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        graph_matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        graph_matrix[2] = new int[]{7, N, N, N, 8, N, N};
        graph_matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        graph_matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        graph_matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        graph_matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        //创建图对象
        Graph graph_case = new Graph(vertex_data, graph_matrix);
        //输出图的邻接矩阵
        graph_case.showGraph();
        //输出最短路径结果, 起点为 G 下标为 6
        graph_case.getMinRoute(3);
    }
}
