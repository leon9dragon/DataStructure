package com.leo9.dc04.singly_link_list;

public class TestDemoSLL {
    public static void main(String[] args) {
        //先创建节点
        TheNode first_node = new TheNode(1,"first_node","first");
        TheNode second_node = new TheNode(2,"second_node","second");
        TheNode third_node = new TheNode(3,"third_node","third");

        //然后创建链表
        SinglyLinkList the_list = new SinglyLinkList();

        //加入节点
        the_list.addNode(first_node);
        the_list.addNode(second_node);
        the_list.addNode(third_node);

        //输出链表
        the_list.showList();
    }
}
