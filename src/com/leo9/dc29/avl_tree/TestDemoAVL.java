package com.leo9.dc29.avl_tree;

public class TestDemoAVL {
    public static void main(String[] args) {
        //int[] sample_arr = {4, 3, 6, 5, 7, 8};
        int[] sample_arr = {10, 12, 8, 9, 7, 6};
        AVLTree sample_tree = new AVLTree();
        for (int i = 0; i < sample_arr.length; i++) {
            sample_tree.addNode(new TreeNode(sample_arr[i]));
        }

        System.out.println("============================\n" + "the result of infix order");
        sample_tree.infixOrder();

        System.out.println("============================\n" + "the height of the origin binary tree is: " + sample_tree.getRoot().getHeight());
        System.out.println("the height of the origin tree's left child tree is: " + sample_tree.getRoot().getLeftHeight());
        System.out.println("the height of the origin tree's right child tree is: " + sample_tree.getRoot().getRightHeight());


    }
}
