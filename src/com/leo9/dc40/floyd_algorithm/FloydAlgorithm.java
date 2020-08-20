package com.leo9.dc40.floyd_algorithm;

public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex_data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] vertex_route = new int[vertex_data.length][vertex_data.length];
        //定义最大值常量
        final int N = 65535;
        //初始化邻接矩阵
        vertex_route[0] = new int[]{0, 5, 7, N, N, N, 2};
        vertex_route[1] = new int[]{5, 0, N, 9, N, N, 3};
        vertex_route[2] = new int[]{7, N, 0, N, 8, N, N};
        vertex_route[3] = new int[]{N, 9, N, 0, N, 4, N};
        vertex_route[4] = new int[]{N, N, 8, N, 0, 5, 4};
        vertex_route[5] = new int[]{N, N, N, 4, 5, 0, 6};
        vertex_route[6] = new int[]{2, 3, N, N, 4, 6, 0};

        Graph graph_case = new Graph(vertex_data,vertex_route);
        graph_case.getRouteByFloydAlgorithm();
        graph_case.showArray();
    }
}
