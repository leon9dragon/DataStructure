package com.leo9.dc37.prim_algorithm;

public class PrimAlgorithm {
    public static void main(String[] args) {
        //定义顶点数组
        char[] vertex_data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertex_num = vertex_data.length;
        //邻接矩阵的关系用二维数组表示, 10000表示两点间不连通
        //因为权值很大的话, 就不会选择到这条边作为通路.
        int[][] side_weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };

        //创建一个图对象
        MapGraph map_graph = new MapGraph(vertex_num);
        //创建一个最小生成树对象
        MinTree min_tree = new MinTree();
        map_graph.initMapGraph(map_graph, vertex_num, vertex_data, side_weight);
        map_graph.showGraph();
    }
}
