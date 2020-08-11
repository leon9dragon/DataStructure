package com.leo9.dc37.prim_algorithm;

import java.util.Arrays;

//定义最小生成树类
public class MinTree {
    /**
     * 编写普里姆算法,得到最小生成树
     *
     * @param map_graph    图对象
     * @param vertex_start 表示从第几个顶点开始生成 MST
     */
    public void getMST(MapGraph map_graph, int vertex_start) {
        //定义数组, 标记结点是否被访问过, 默认元素值为 0, 表示没访问过
        int[] vertex_visited = new int[map_graph.vertex_num];

        //将当前结点标记为已访问
        vertex_visited[vertex_start] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1, h2;
        h1 = h2 = -1;
        //将最小值初始化一个较大的数, 后面遍历的时候会被替换
        int minWeight = 10000;

        //开始循环遍历, 因为最小连通子图的边数为 vertex_num-1
        //因此 k 初始值为 1, 遍历结束后就能获取顶点数减一条边
        for (int k = 1; k < map_graph.vertex_num; k++) {
            for (int i = 0; i < map_graph.vertex_num; i++) {
                for (int j = 0; j < map_graph.vertex_num; j++) {
                    //寻找已被访问过的顶点与未被访问的顶点的连线的权值中的最小值
                    //即选出当前已访问的顶点与未访问的顶点中的最小边
                    //因为给定的邻接矩阵是完全图, 不连通的点之间的边的权值用大数值表示, 因此不会影响判断最小值
                    if(vertex_visited[i] == 1
                            && vertex_visited[j]==0
                            && map_graph.side_weight[i][j] < minWeight){
                        //找到最小边后替换最小值, 同时更新点的坐标
                        minWeight = map_graph.side_weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
        }
    }
}
