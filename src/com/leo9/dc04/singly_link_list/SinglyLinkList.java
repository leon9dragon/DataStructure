package com.leo9.dc04.singly_link_list;

/**
 * 定义单链表类
 */

public class SinglyLinkList {
    //初始化头节点,不存放具体数据
    private TheNode head_node = new TheNode(0,"","");

    //添加节点
    //当不需要考虑编号顺序直接插入链表时
    //1.找到当前链表最后的节点
    //2.将最后这个节点的next指向新的节点
    public void addNode(TheNode new_node){
        //因为head节点不能动, 因此需要一个辅助指针temp
        TheNode temp = head_node;
        //开始遍历链表, 找到最后一个节点
        while (true){
            //如果找到了最后一个节点,则跳出循环
            if(temp.next == null){
                break;
            }
            //如果没有找到最后一个节点,指针后移
            temp = temp.next;
        }
        //当退出循环时,此时temp就指向了链表最后
        //因此将最后节点的next域指向当前新增节点
        temp.next = new_node;
    }

    //排序添加节点
    //首先找出正确的位置
    //然后当前节点的next域指向前一个节点next域所指向的位置
    //最后前一个节点的next域改为指向当前节点
    public void addNodeOrder(TheNode new_node){
        //编号不能小于等于0
        if(new_node.no <= 0){
            System.out.println("the no cant be 0 or less than 0 !");
            return;
        }
        //因为head节点不能动, 因此需要一个辅助指针temp
        TheNode temp = head_node;
        while(true){
            //当指针指到最后一个节点时, 跳出循环
            if(temp.next == null){
                temp.next = new_node;
                break;
            }

            //找到要插入的位置的前一个节点
            if(temp.next.no > new_node.no){
                new_node.next = temp.next;
                temp.next = new_node;
                break;
            }
            else if(temp.next.no == new_node.no){
                System.out.println("this no:"+ new_node.no + " is existed!");
                break;
            }
            temp = temp.next;
        }
    }

    //显示链表
    public void showList(){
        //先判断链表是否为空
        if(head_node.next == null){
            System.out.println("the list is empty!");
        }
        //因为头节点不能动,因此需要辅助指针
        //因为头节点next域不为空,因此至少有一个数据
        TheNode temp = head_node.next;
        while (true){
            //判断链表是否走到最后
            if(temp == null){
                break;
            }
            //输出当前节点
            System.out.println(temp);
            //节点后移
            temp = temp.next;
        }
    }
}
