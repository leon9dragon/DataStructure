package com.leo9.dc06.circle_link_list;

public class TheNodeC {
    public int no;
    public String name;
    public String nick_name;
    //节点的next域
    public TheNodeC next;


    //定义构造器
    public TheNodeC(int no, String name, String nick_name){
        this.no = no;
        this.name = name;
        this.nick_name = nick_name;
    }

    //重写toString方法

    @Override
    public String toString() {
        return "TheNodeD{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                '}';
    }
}
