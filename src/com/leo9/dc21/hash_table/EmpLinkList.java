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
    public void viewList(int no){
        //判断头节点是否为空, 如果为空则链表为空
        if(head_node == null){
            System.out.printf("the list[%d] is empty\n", no);
            return;
        }
        System.out.printf("the list[%d] ", no);
        EmpNode cur_node = head_node;
        while(true){
            //输出节点信息
            System.out.printf("=> [id = %d, name = %s]\t", cur_node.id, cur_node.name);
            //判断当前节点下一位是否为空, 为空则跳出循环
            if(cur_node.next_emp == null){
                break;
            }
            //后移一位
            cur_node = cur_node.next_emp;
        }
        System.out.println();
    }

    //根据id查找员工
    //如果找到就返回员工相应信息, 如果没找到就返回null
    public EmpNode searchEmpById(int id){
        //先判断当前链表是否为空
        if(head_node == null){
            //System.out.println("this list is empty");
            return null;
        }

        //遍历链表寻找是否存在员工
        EmpNode cur_node = head_node;
        while(true){
            //找到则跳出循环, 然后返回该员工节点.
            if(cur_node.id == id){
                break;
            }
            //全表遍历完仍找不到则返回空
            if(cur_node.next_emp == null){
                //System.out.println("this employer is not existed");
                return null;
            }
            cur_node = cur_node.next_emp;
        }
        return cur_node;
    }
}
