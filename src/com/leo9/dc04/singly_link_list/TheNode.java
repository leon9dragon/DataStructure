package com.leo9.dc04.singly_link_list;
/**
 * 定义节点类
 * */

public class TheNode {
    public int no;
    public String name;
    public String nick_name;
    public TheNode next;

    //定义构造器
    public TheNode(int no, String name, String nick_name){
        this.no = no;
        this.name = name;
        this.nick_name = nick_name;
    }

    //重写toString方法

    @Override
    public String toString() {
        return "TheNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                '}';
    }
}
