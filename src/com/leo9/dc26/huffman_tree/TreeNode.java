package com.leo9.dc26.huffman_tree;

//创建结点类
//为了能让TreeNode对象支持排序 如Collections集合排序
//因此让TreeNode实现Comparable接口
public class TreeNode implements Comparable<TreeNode> {
    //定义结点权值
    public int value;
    //定义结点的左右子结点
    public TreeNode left_node;
    public TreeNode right_node;

    //定义构造器
    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    //重写toString方法
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    @Override
    //实现接口的比较方法
    public int compareTo(TreeNode treeNode) {
        //表示从小到大排序
        return this.value - treeNode.value;
    }

    //前序遍历二叉树
    public void preOrder() {
        System.out.println(this);
        if (this.left_node != null) {
            this.left_node.preOrder();
        }
        if (this.right_node != null) {
            this.right_node.preOrder();
        }
    }
}
