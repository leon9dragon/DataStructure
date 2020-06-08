package com.leo9.dc22.binary_tree;

public class TestDemoBT {
    public static void main(String[] args) {
        //手动创建一棵二叉树的所有节点
        TreeNode nodeA = new TreeNode(1,"A");
        TreeNode nodeB = new TreeNode(2,"B");
        TreeNode nodeC = new TreeNode(3,"C");
        TreeNode nodeD = new TreeNode(4,"D");
        TreeNode nodeE = new TreeNode(5,"E");
        TreeNode nodeF = new TreeNode(6,"F");
        TreeNode nodeG = new TreeNode(7,"G");

        //手动连接各个节点
        nodeA.setLeft_node(nodeB);
        nodeA.setRight_node(nodeC);
        nodeB.setLeft_node(nodeD);
        nodeB.setRight_node(nodeE);
        nodeC.setLeft_node(nodeF);
        nodeC.setRight_node(nodeG);

        //将根节点放入二叉树
        BinaryTree testTree = new BinaryTree();
        testTree.setRoot_node(nodeA);

        //测试前序遍历
        System.out.println("========test preOrder=======");
        testTree.preOrder();
        //测试中序遍历
        System.out.println("========test infixOrder=======");
        testTree.infixOrder();
        //测试后序遍历
        System.out.println("========test postOrder=======");
        testTree.postOrder();
    }
}
