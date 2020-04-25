package com.leo9.dc06.circle_link_list;


public class TestDemoCLL {
    public static void main(String[] args) {
        //region 约瑟夫环实现

        //创建链表
        CircleLinkList crlist = new CircleLinkList();

        //循环增加节点
        for(int i = 1; i < 6; i++){
            crlist.addNode(new TheNodeC(i,"NO." + i,""));
        }

        crlist.showList();
        System.out.println("the number of the node is " + crlist.getNum_of_node());
        System.out.println("===============================");

        //开始报数
        System.out.println("here is the order of deleting nodes");
        //定义临时节点,并指向第一个节点
        TheNodeC temp = crlist.getHead_pointer();
        while(crlist.getNum_of_node() != 0){
            //若设定报数为2出列,则当前节点的下一节点则为出列节点
            int del_no = temp.next.no;
            System.out.println("delete the node named: NO." + del_no);

            //删除目标节点
            crlist.delNode(del_no);

            //temp指针后移
            temp = temp.next;
        }

        System.out.println("===============================");
        System.out.println("the number of the node is " + crlist.getNum_of_node());
        System.out.println("all of nodes are deleted");
        //endregion
    }

}
