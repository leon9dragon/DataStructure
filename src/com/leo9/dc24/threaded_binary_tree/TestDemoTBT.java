package com.leo9.dc24.threaded_binary_tree;

public class TestDemoTBT {
    public static void main(String[] args) {
        //测试中序线索二叉树的功能
        //二叉树后续会递归创建, 这里测试先手动进行创建
        TreeNode node1 = new TreeNode(1,"Tom");
        TreeNode node2 = new TreeNode(3,"Jack");
        TreeNode node3 = new TreeNode(6,"Smith");
        TreeNode node4 = new TreeNode(8,"Mary");
        TreeNode node5 = new TreeNode(10,"Kim");
        TreeNode node6 = new TreeNode(14,"Dick");

        //手动连接各个结点间的关系
        node1.setLeft_node(node2);
        node1.setRight_node(node3);
        node2.setLeft_node(node4);
        node2.setRight_node(node5);
        node3.setLeft_node(node6);

        //测试线索化
        ThreadBinaryTree testTree = new ThreadBinaryTree();
        testTree.setRoot_node(node1);
        testTree.threadedNode(node1);

        //以10号结点测试, 看其前驱和后继结点是否为3号和1号
//        System.out.println(node4.getLeft_node());
//        System.out.println(node4.getRight_node());

        System.out.println("=======show ThreadList======");
        testTree.threadedList();

    }
}
