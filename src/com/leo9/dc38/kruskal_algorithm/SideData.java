package com.leo9.dc38.kruskal_algorithm;

//创建一个边的类, 它的对象实例就表示一条边
public class SideData {
    //定义边的两个端点
    char start_point;
    char end_point;
    //定义边的权值
    int side_weight;

    public SideData(char start_point, char end_point, int side_weight) {
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
