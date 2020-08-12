package com.leo9.dc37.prim_algorithm;

import java.util.Arrays;

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

        //创建一个图对象, 并进行初始化
        MapGraph map_graph = new MapGraph(vertex_num);
        map_graph.initMapGraph(map_graph, vertex_num, vertex_data, side_weight);

        //打印初始的图
        System.out.println("==============target graph===============");
        map_graph.showGraph();

        //打印最小生成树相关信息, 从数组下标为0的点开始
        getMST(map_graph, 0);
    }

    /**
     * 编写普里姆算法,得到最小生成树
     *
     * @param map_graph    图对象
     * @param vertex_start 表示从第几个顶点开始生成 MST
     */
    public static void getMST(MapGraph map_graph, int vertex_start) {
        //定义数组, 标记结点是否被访问过, 默认元素值为 0, 表示没访问过
        int[] vertex_visited = new int[map_graph.vertex_num];

        //定义最小生成树的邻接矩阵, 用来存储边的权值, 通路为 1, 不通为 0
        int[][] min_tree = new int[map_graph.vertex_num][map_graph.vertex_num];

        //定义最短路径长度, 用来计算最小生成树所有通路的权值之和
        int min_route = 0;

        //将当前结点标记为已访问
        vertex_visited[vertex_start] = 1;

        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;

        //将最小值初始化一个较大的数, 后面遍历的时候会被替换
        int min_weight = 10000;

        System.out.println("==============the chosen sides===============");
        //开始循环遍历, 因为最小连通子图的边数为 vertex_num-1
        //因此 k 初始值为 1, 遍历结束后就能获取顶点数减一条边
        for (int k = 1; k < map_graph.vertex_num; k++) {
            //寻找已被访问过的顶点与未被访问的顶点的连线的权值中的最小值
            //即选出当前已访问的顶点与未访问的顶点中的最小边
            //因为给定的邻接矩阵是完全图, 不连通的点之间的边的权值用大数值表示, 因此不会影响判断最小值
            for (int i = 0; i < map_graph.vertex_num; i++) {
                for (int j = 0; j < map_graph.vertex_num; j++) {
                    //通过遍历比较找到每一轮的最小边, 获取是哪两个顶点
                    //h1用来记录被访问顶点, h2用来记录未访问顶点
                    if (vertex_visited[i] == 1
                            && vertex_visited[j] == 0
                            && map_graph.side_weight[i][j] < min_weight) {
                        //找到最小边后替换最小值, 同时更新点的下标
                        min_weight = map_graph.side_weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //中间的双重循环结束后能找出第 k 条边, 存储相应的数据
            //最小生成树的邻接矩阵记录边的权值, 因为是无向图, 所以两个方向的边权值都记为 1
            min_tree[h1][h2] = 1;
            min_tree[h2][h1] = 1;
            //最短路径长度进行累加
            min_route += map_graph.side_weight[h1][h2];
            //本轮新增边的另一个未被访问的端点记录已访问
            vertex_visited[h2] = 1;
            //输出边
            System.out.printf("the side <%c,%c> is chosen, length = [%d]\n", map_graph.vertex_data[h1], map_graph.vertex_data[h2], map_graph.side_weight[h1][h2]);
            //min_weight 重置, 防止后续对比出错
            min_weight = 10000;
        }
        //输出最小生成树
        System.out.println("==============the min tree===============");
        for (int[] row : min_tree) {
            System.out.println(Arrays.toString(row));
        }

        //输出最短路径
        System.out.println("==============the min route===============");
        System.out.printf("the min route is [%d]\n", min_route);
    }
}
