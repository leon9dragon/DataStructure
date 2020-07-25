package com.leo9.dc30.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphMatrix {
    //定义一个 ArrayList 用来存储图中的顶点的数据集合
    private ArrayList<String> graph_vertex_list;
    //定义一个二维数组存储图对应的邻接矩阵
    private int[][] graph_edge_arr;
    //定义变量存储图中的边的数目
    private int edge_num;

    //region 构造器, 参数是顶点数量
    public GraphMatrix(int vertex_num) {
        //初始化邻接矩阵和顶点集合, 边的数目
        //如果顶点有n个, 邻接矩阵就是n*n的矩阵
        graph_edge_arr = new int[vertex_num][vertex_num];
        //定义顶点集合的容量, 和顶点数量一致
        graph_vertex_list = new ArrayList<String>(vertex_num);
        //因为一开始并不知道有多少条边, 初始化的时候为0即可(这一步不写也可以)
        edge_num = 0;
    }
    //endregion

    //region 定义添加结点方法, 参数是结点对应的字符串
    public void insertVertex(String vertex_str) {
        //直接添加到集合即可
        graph_vertex_list.add(vertex_str);
    }
    //endregion

    //region 定义添加边的方法

    /**
     * @param vertex1     结点1在集合中的编号, 即顶点在集合中的下标[0~n]
     * @param vertex2     结点2在集合中的编号, 即顶点在集合中的下标[0~n]
     * @param edge_weight 两个结点之间边的权值, 默认为 0 不连通, 大于 0 就连通
     */
    public void insertEdge(int vertex1, int vertex2, int edge_weight) {
        //因为是无向图. 因此顶点间的两个方向的边都要进行定义
        graph_edge_arr[vertex1][vertex2] = edge_weight;
        graph_edge_arr[vertex2][vertex1] = edge_weight;
        //边产生之后, 边的数目自增
        edge_num++;
    }
    //endregion

    //region 图中常用的方法
    //region 返回结点的个数
    public int getVertexNum(){
        //直接返回顶点集合的size即可
        return graph_vertex_list.size();
    }
    //endregion

    //region 返回边的数目
    public int getEdgeNum(){
        //直接返回边的数目即可
        return edge_num;
    }
    //endregion

    //region 返回结点下标对应的结点数据, 例如 0 号结点对应结点数据为 "A"
    public String getValByIndex(int vertex_index){
        return graph_vertex_list.get(vertex_index);
    }
    //endregion

    //region 返回vertex1和vertex2构成的边的权值
    public int getEdgeWeight(int vertex1, int vertex2){
        //直接返回二维数组的对应下标成员即可
        return graph_edge_arr[vertex1][vertex2];
    }
    //endregion

    //region 显示图所对应的邻接矩阵
    public void showGraphMatrix(){
        for(int[] link : graph_edge_arr){
            System.out.println(Arrays.toString(link));
        }
    }
    //endregion

    //endregion
}
