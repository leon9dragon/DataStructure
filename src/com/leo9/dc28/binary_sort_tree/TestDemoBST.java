package com.leo9.dc28.binary_sort_tree;

public class TestDemoBST {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.addNode(new TreeNode(arr[i]));
        }
        //中序遍历二叉排序树
        System.out.println("=========================");
        binarySortTree.infixOrder();
    }

}
