package com.leo9.dc05.double_link_list;



public class DoubleLinkList {
    //初始化头节点,不存放具体数据
    private TheNodeD head_node = new TheNodeD(0,"","");


    //region 添加节点到链表尾部
    //当不需要考虑编号顺序直接插入链表时
    //1.找到当前链表最后的节点
    //2.将最后这个节点的next指向新的节点
    public void addNode(TheNodeD new_node){
        //因为head节点不能动, 因此需要一个辅助指针temp
        TheNodeD temp = head_node;
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
        //因此将新增节点的pre域指向原先的最后节点
        temp.next = new_node;
        new_node.pre = temp;
    }
    //endregion

    //排序添加节点
    //首先找出正确的位置

    public void addNodeOrder(TheNodeD new_node){
        //编号不能小于等于0
        if(new_node.no <= 0){
            System.out.println("the no cant be 0 or less than 0 !");
            return;
        }

        //因为head节点不能动, 因此需要一个辅助指针temp
        //找出要插入位置的前一个节点
        TheNodeD temp = head_node;
        while(true){
            //当前节点为空直接跳出
            if(temp.next == null){
                break;
            }

            if(temp.next.no > new_node.no){
                break;
            }
            temp = temp.next;
        }

        //插入节点, 防止空指针异常, 先对插入节点是否插入到队列尾部进行判断
        if(temp.next != null){
            temp.next.pre = new_node;
            new_node.next = temp.next;
        }
        new_node.pre = temp;
        temp.next = new_node;
    }

    //修改节点, 根据no来寻找节点, 因此no不能被修改
    public void editNode(int edit_no, String new_name, String new_nick_name){
        //因为head节点不能动, 因此需要一个辅助指针temp
        TheNodeD temp = head_node;
        while (true){
            if(temp.no == edit_no){
                temp.name = new_name;
                temp.nick_name = new_nick_name;
                break;
            }

            if(temp.next == null){
                System.out.println("this node:" + edit_no + " is not existed!");
                break;
            }
            temp = temp.next;
        }
    }

    //删除节点, 根据no来进行查找
    public void delNode(int del_no){
        //因为head节点不能动, 因此需要一个辅助指针temp
        //因为是双向链表, 节点可以自删除, 因此可以从第一个有效节点开始查找
        TheNodeD temp = head_node.next;
        while(true){
            if(temp == null){
                System.out.println("this node: " + del_no + " is not existed!");
                break;
            }

            //因为是双向链表, 因此直接找到当前节点即可
            if(temp.no == del_no){
                temp.pre.next = temp.next;
                //若要删除的是最后一个节点,防止出现空指针异常,先判断当前节点next域是否为空
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
                break;
            }

            //指针后移
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
        TheNodeD temp = head_node.next;
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
