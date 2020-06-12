package com.leo9.dc23.array_binary_tree;

public class TestDemoABT {
    public static void main(String[] args) {
        int[] test_array = {1,2,3,4,5,6,7};
        ArrayBinaryTree arr_tree = new ArrayBinaryTree(test_array);
        System.out.println("======test preOrder======");
        arr_tree.preOrder(0);
        System.out.println("======test infixOrder======");
        arr_tree.infixOrder(0);
        System.out.println("======test postOrder======");
        arr_tree.postOrder(0);
    }
}
