package com.leo9.dc23.array_binary_tree;

public class TestDemoABT {
    public static void main(String[] args) {
        int[] test_array = {1,3,6,8,10,14};
        ArrayBinaryTree arr_tree = new ArrayBinaryTree(test_array);
        arr_tree.infixOrder(0);
    }
}
