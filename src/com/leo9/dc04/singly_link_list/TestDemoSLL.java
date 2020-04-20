package com.leo9.dc04.singly_link_list;

public class TestDemoSLL {
    public static void main(String[] args) {
        //先创建节点
        TheNode first_node = new TheNode(1,"first_node","first");
        TheNode second_node = new TheNode(2,"second_node","second");
        TheNode third_node = new TheNode(3,"third_node","third");
        TheNode third_node_2 = new TheNode(3,"third_node_2","third_2");
        TheNode fourth_node = new TheNode(4,"fourth_node","fourth");

        //然后创建链表
//        SinglyLinkList the_list01 = new SinglyLinkList();
        SinglyLinkList the_list02 = new SinglyLinkList();

//        //直接加入节点
//        System.out.println("==============================================");
//        the_list01.addNode(first_node);
//        the_list01.addNode(second_node);
//        the_list01.addNode(third_node);
//        the_list01.addNode(fourth_node);
//
//        //输出链表
//        the_list01.showList();


        //按顺序加入节点
        System.out.println("==============================================");
        the_list02.addNodeOrder(first_node);
        the_list02.addNodeOrder(second_node);
        the_list02.addNodeOrder(fourth_node);
        the_list02.addNodeOrder(third_node);
        the_list02.addNodeOrder(third_node_2);

        //输出链表
        the_list02.showList();

        //修改节点
        System.out.println("==============================================");
        the_list02.editNode(5,"test","ttt");
        the_list02.editNode(4,"4ourth_node","4ourth");

        //输出链表
        the_list02.showList();

//        //删除节点
//        System.out.println("==============================================");
//        the_list02.delNode(3);
//        the_list02.delNode(5);
//
//        //输出链表
//        the_list02.showList();

        //反转链表
        System.out.println("==============================================");
        the_list02.reversalList().showList();
    }
}
