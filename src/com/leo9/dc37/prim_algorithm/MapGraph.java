package com.leo9.dc37.prim_algorithm;

import java.util.Arrays;

//定义图类
public class MapGraph {
    //定义图的结点个数
    int vertex_num;
    //存放结点的数据
    char[] vertex_data;
    //邻接矩阵存放权值
    int[][] side_weight;

    //定义构造器, 初始化上述内容
    public MapGraph(int vertex_num) {
        this.vertex_num = vertex_num;
        vertex_data = new char[vertex_num];
        side_weight = new int[vertex_num][vertex_num];
    }

    /**
     * 初始化图的邻接矩阵
     *
     * @param map_graph   图对象
     * @param vertex_num  图的顶点个数
     * @param vertex_data 图的顶点值
     * @param side_weight 图的邻接矩阵
     */
    public void initMapGraph(MapGraph map_graph, int vertex_num, char[] vertex_data, int[][] side_weight) {
        int i, j;
        for (i = 0; i < vertex_num; i++) {
            map_graph.vertex_data[i] = vertex_data[i];
            for (j = 0; j < vertex_num; j++) {
                map_graph.side_weight[i][j] = side_weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph() {
        for (int[] row : this.side_weight) {
            System.out.println(Arrays.toString(row));
        }
    }
}
