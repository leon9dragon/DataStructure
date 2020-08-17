package com.leo9.dc39.dijkstra_algorithm;

import java.util.Arrays;

public class VertexVisited {
    //定义数组记录各个顶点是否被访问过
    public int[] already_arr;
    //定义数组记录出发顶点到其他所有顶点的距离
    public int[] dis_arr;
    //定义数组记录每个结点对应的前驱结点
    public Integer[] pre_visited;

    //定义构造器, vertex_num 表示顶点个数, vertex_index 表示出发顶点的下标
    public VertexVisited(int vertex_num, int vertex_index) {
        this.already_arr = new int[vertex_num];
        this.dis_arr = new int[vertex_num];
        this.pre_visited = new Integer[vertex_num];
        //初始化距离数组, 并将起点到自身的距离设置为 0
        Arrays.fill(this.dis_arr, 65535);
        this.dis_arr[vertex_index] = 0;
        //再设置出发顶点为已访问
        already_arr[vertex_index] = 1;
    }

    //定义方法判断index顶点是否被访问过, 如果访问过, 返回true, 否则返回false.
    public boolean visitedOrNot(int vertex_index) {
        return already_arr[vertex_index] == 1;
    }

    //定义方法来更新距离数组, 更新的是出发顶点到index顶点的距离
    public void updateDis(int vertex_index, int new_distance) {
        dis_arr[vertex_index] = new_distance;
    }

    //定义方法来更新前驱结点数组, 更新的是index点的前驱结点,
    //前驱结点在结点数组的下标为 pre_index
    public void updatePre(int vertex_index, int pre_index) {
        pre_visited[vertex_index] = pre_index;
    }

    //定义方法来获取出发点到index顶点的距离
    public int getDis(int vertex_index) {
        return dis_arr[vertex_index];
    }

    //继续选择并返回新的访问顶点, 例如 G 访问完后, 就以 A,B,E,F 作为新的起点进行遍历访问
    public int updateStartPoint() {
        int min = 65535;
        int index = 0;
        //循环遍历, 从能连通的未被访问的顶点中选择路径最短的顶点出来作为下一个访问起点
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis_arr[i] < min) {
                min = dis_arr[i];
                index = i;
            }
        }
        //更新index顶点被访问过
        already_arr[index] = 1;
        return index;
    }
}
