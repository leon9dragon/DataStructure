package com.leo9.dc21.hash_table;

//定义员工节点类, 用来存放员工信息
//同时链表是单链表, 所以只需要定义指向下一节点
public class EmpNode {
    public int id;
    public String name;
    public EmpNode next_emp;

    public EmpNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
