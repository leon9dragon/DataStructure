package com.leo9.dc30.graph;

public class TestGraphMatrix {
    public static void main(String[] args) {
        //结点个数
        int vertex_num = 5;
        //用字符串数组存放结点值
        String[] VertexVal = {"A", "B", "C", "D", "E"};
        //创建图对象
        GraphMatrix graph_matrix = new GraphMatrix(vertex_num);
        //循环添加顶点
        for(String vertex_val: VertexVal){
            graph_matrix.insertVertex(vertex_val);
        }
        //添加边, 因为是无向图, 添加一次即可
        //A-B A-C B-C B-D B-E
        graph_matrix.insertEdge(0,1,1);
        graph_matrix.insertEdge(0,2,1);
        graph_matrix.insertEdge(1,2,1);
        graph_matrix.insertEdge(1,3,1);
        graph_matrix.insertEdge(1,4,1);

        //列印邻接矩阵
        graph_matrix.showGraphMatrix();
    }
}
