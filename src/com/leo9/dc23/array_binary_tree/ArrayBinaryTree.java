package com.leo9.dc23.array_binary_tree;

//编写一个类实现顺序存储二叉树遍历
public class ArrayBinaryTree {
    //定义成员变量用以接收数组二叉树
    private int[] arr_btree;

    public ArrayBinaryTree(int[] arr_btree) {
        this.arr_btree = arr_btree;
    }

    //定义setter方法用以接收数组
    public void setArr_btree(int[] arr_btree) {
        this.arr_btree = arr_btree;
    }

    //region 编写方法来完成顺序存储二叉树的遍历
    //1.完成前序遍历的方法, 需要传入每次开始结点的下标
    public void preOrder(int begin_num){
        //输出当前结点
        System.out.printf("node[no=%d, val=%d]\n", begin_num, arr_btree[begin_num]);

        //判断当前结点的左子结点 2*n+1 是否存在
        //只要小于等于数组下标最大值, 结点就存在
        if(2*begin_num+1 <= arr_btree.length-1){
            preOrder(2*begin_num+1);
        }

        //判断当前结点的右子结点 2*n+2 是否存在
        //只要小于等于数组下标最大值, 结点就存在
        if(2*begin_num+2 <= arr_btree.length-1){
            preOrder(2*begin_num+2);
        }
    }

    //2.完成中序遍历的方法, 需要传入每次开始结点的下标
    public void infixOrder(int begin_num){
        //判断当前结点的左子结点 2*n+1 是否存在
        //只要小于等于数组下标最大值, 结点就存在
        if(2*begin_num+1 <= arr_btree.length-1){
            infixOrder(2*begin_num+1);
        }

        //输出当前结点
        System.out.printf("node[no=%d, val=%d]\n", begin_num, arr_btree[begin_num]);

        //判断当前结点的右子结点 2*n+2 是否存在
        //只要小于等于数组下标最大值, 结点就存在
        if(2*begin_num+2 <= arr_btree.length-1){
            infixOrder(2*begin_num+2);
        }
    }

    //3.完成后序遍历的方法, 需要传入每次开始结点的下标
    public void postOrder(int begin_num){
        //判断当前结点的左子结点 2*n+1 是否存在
        //只要小于等于数组下标最大值, 结点就存在
        if(2*begin_num+1 <= arr_btree.length-1){
            postOrder(2*begin_num+1);
        }

        //判断当前结点的右子结点 2*n+2 是否存在
        //只要小于等于数组下标最大值, 结点就存在
        if(2*begin_num+2 <= arr_btree.length-1){
            postOrder(2*begin_num+2);
        }

        //输出当前结点
        System.out.printf("node[no=%d, val=%d]\n", begin_num, arr_btree[begin_num]);
    }
    //endregion
}
