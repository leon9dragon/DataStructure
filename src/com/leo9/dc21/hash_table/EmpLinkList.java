package com.leo9.dc21.hash_table;

//定义员工链表类, 存放每个链表的头节点, 和实现链表增删查改的方法
public class EmpLinkList {
    //头节点, 指向当前链表的第一个员工, 因此头节点是有效节点
    private EmpNode head_node;

    //定义添加新员工节点的方法
    //假定添加员工时, id是自增长的, 即id总是从小到大
    //因此直接将新节点添加到链表尾部即可
    public void addEmployer(EmpNode new_node){
        //先判断头节点是否为空
        if(head_node == null){
            head_node = new_node;
            return;
        }

        //如果不是当前链表的第一个员工, 使用辅助指针帮助定位
        EmpNode cur_node = head_node;
        while(true){
            if(cur_node.next_emp != null){
                cur_node = cur_node.next_emp;
            }else {
                cur_node.next_emp = new_node;
                break;
            }
        }
    }

    //遍历链表的雇员信息
    public void viewList(){
        //判断头节点是否为空, 如果为空则链表为空
        if(head_node == null){
            System.out.println("the list is empty");
            return;
        }
        System.out.println("the info in the list is");
        
    }
}
