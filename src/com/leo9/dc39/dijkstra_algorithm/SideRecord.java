package com.leo9.dc39.dijkstra_algorithm;

public class SideRecord {
    //定义边的起点和终点
    char start_point;
    char end_point;
    //定义边的权值
    int side_weight;

    public SideRecord(char start_point, char end_point, int side_weight) {
        this.start_point = start_point;
        this.end_point = end_point;
        this.side_weight = side_weight;
    }

    @Override
    public String toString() {
        return "<" + start_point +
                ", " + end_point +
                "> = " + side_weight;
    }
}
