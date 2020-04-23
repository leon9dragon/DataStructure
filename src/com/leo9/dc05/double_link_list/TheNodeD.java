package com.leo9.dc05.double_link_list;

import com.leo9.dc04.singly_link_list.TheNode;

public class TheNodeD {
    public int no;
    public String name;
    public String nick_name;
    //节点的next域
    public TheNodeD next;
    //节点的pre域
    public TheNodeD pre;

    //定义构造器
    public TheNodeD(int no, String name, String nick_name){
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
