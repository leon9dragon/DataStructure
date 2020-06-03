package com.leo9.dc21.hash_table;

//定义HashTable 管理多条链表
public class EmpHashTable {
    private EmpLinkList[] empLinkListsArray;
    //定义一个尺寸表示该哈希表中存放有多少条链表
    private int size;

    //构造器, 指定哈希表有多少条链表, 并进行初始化
    public EmpHashTable(int size){
        this.size = size;
        //根据尺寸构建哈希表
        empLinkListsArray = new EmpLinkList[size];
        //初始化哈希表内的每一条链表
        for (int i = 0; i < size; i++) {
            empLinkListsArray[i] = new EmpLinkList();
        }
    }

    //编写散列函数, 使用取模法进行编写
    public int hashFun(int id){
        return id % size;
    }

    //添加员工
    public void add(EmpNode emp_node){
        //根据员工的id, 得到该员工应当添加到哪条链表
        int empLinkListNO = hashFun(emp_node.id);
        //将员工节点添加到对应的链表中
        empLinkListsArray[empLinkListNO].addEmployer(emp_node);
    }

    //遍历哈希表的所有链表
    public void viewList(){
        for(int i = 0; i < size; i++){
            empLinkListsArray[i].viewList(i);
        }
    }

    //查找员工
    public void searchEmpById(int id){
        EmpNode node = empLinkListsArray[hashFun(id)].searchEmpById(id);
        if(node != null){
            System.out.printf("the employer[id = %d] is existed in list[%d], the info is [id = %d, name = %s]\n", id, hashFun(id), node.id, node.name);
        }
        else {
            System.out.printf("the employer[id = %d] is not existed\n", id);
        }
    }
}
