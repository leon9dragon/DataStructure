package com.leo9.dc39.dijkstra_algorithm;

import java.util.ArrayList;
import java.util.Arrays;

//创建图类
public class Graph {
    //创建顶点数组
    private char[] vertex_data;
    //创建邻接矩阵
    private int[][] graph_matrix;
    //创建内置的顶点访问对象作为属性
    private VertexVisited vertex_visited;
    //定义边集合
    private ArrayList<SideRecord> side_record = new ArrayList<SideRecord>();

    //定义构造函数
    public Graph(char[] vertex_data, int[][] graph_matrix) {
        this.vertex_data = vertex_data;
        this.graph_matrix = graph_matrix;
    }

    //定义显示图的方法
    public void showGraph() {
        System.out.println("=========show the graph's matrix=========");
        for (int i = 0; i < graph_matrix[0].length; i++) {
            if (i == 0) {
                System.out.printf("%-3c", '\\');
            }
            System.out.printf("%-3c", 'A' + i);
        }
        System.out.println();
        for (int i = 0; i < graph_matrix.length; i++) {
            System.out.printf("%-3c", 'A' + i);
            for (int j = 0; j < graph_matrix[i].length; j++) {
                if (graph_matrix[i][j] == 65535) {
                    System.out.printf("%-3s", "N");
                } else {
                    System.out.printf("%-3d", graph_matrix[i][j]);
                }
            }
            System.out.println();
        }
    }


    //更新index下标顶点到周围顶点的距离和周围顶点的前驱结点
    private void updateData(int vertex_index) {
        int new_distance = 0;
        //遍历目标index起点所在的邻接矩阵那一行, 进行更新距离数组
        for (int i = 0; i < graph_matrix[vertex_index].length; i++) {
            //新距离的含义是: 先获取当前起点到其所有前驱结点的距离, 然后再加上当前起点到下一个顶点的距离.
            //所有前驱结点的距离的含义: 这个前驱结点的距离是不断累加的, 是从出发点一直连接到当前起点间的最短距离.
            new_distance = vertex_visited.getDis(vertex_index) + graph_matrix[vertex_index][i];

            //进行判断, 如果下一顶点未被访问过且当前新的距离比上次出发点到下一顶点的距离要小, 则进行距离更新
            //注意: 出发点一般来说都没有前驱结点, 在Integer数组中对应的前驱结点为NULL
            if (!vertex_visited.visitedOrNot(i) && new_distance < vertex_visited.getDis(i)) {
                vertex_visited.updatePre(i, vertex_index);
                vertex_visited.updateDis(i, new_distance);

                //这里加入对最小连通路径的记录, 记录每一条用于连通出发点到终点的连接边
                //删除被记录的边中重复结束端的边, 因为有比它更小的边加入了
                for (int j = 0; j < side_record.size(); j++) {
                    if (side_record.get(j).end_point == vertex_data[i]) {
                        side_record.remove(j);
                    }
                }

                //记录每一条被选中的边
                side_record.add(new SideRecord(vertex_data[vertex_index], vertex_data[i], graph_matrix[vertex_index][i]));
            }
        }
    }


    //定义实现迪杰斯特拉算法的方法, 传入的是出发起点的数组下标
    public void getMinRoute(int start_index) {
        //先定义一个顶点访问对象
        vertex_visited = new VertexVisited(vertex_data.length, start_index);
        //更新出发点到周围邻接点的距离
        updateData(start_index);
        //然后循环更新起点和距离, 因为上面已经有一个点被访问过了, 所以 i 从 1 开始
        for (int i = 1; i < vertex_data.length; i++) {
            start_index = vertex_visited.updateStartPoint();
            updateData(start_index);
        }
        //输出结果
        showResult();
    }

    //定义方法输出最终结果
    public void showResult() {
        System.out.println("===========show result===========");
        System.out.printf("%-15s", "the_vertex");
        for (char data : vertex_data) {
            System.out.printf("%-4c", data);
        }
        System.out.println();

        System.out.printf("%-15s", "last_vertex");
        for (Integer data : vertex_visited.pre_visited) {
            if (data != null) {
                System.out.printf("%-4d", data);
            } else {
                System.out.printf("%-4c", 'N');
            }
        }
        System.out.println();

        System.out.printf("%-15s", "min_route");
        for (int data : vertex_visited.dis_arr) {
            System.out.printf("%-4d", data);
        }
        System.out.println("\nNOTICE: this min route is the route from start point to end point!");
        System.out.println("EXAMPLE: route(G->C) = route(G->A) + route(A->C) = 2 + 7 = 9");

        System.out.println("===========show sides===========");
        int min_route = 0;
        for (int i = 0; i < side_record.size(); i++) {
            System.out.println(side_record.get(i));
            min_route += side_record.get(i).side_weight;
        }
        System.out.printf("\nall route = [%d]\n", min_route);
    }
}
