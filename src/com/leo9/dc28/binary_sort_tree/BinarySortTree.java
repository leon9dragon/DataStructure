package com.leo9.dc28.binary_sort_tree;

public class BinarySortTree {
    private TreeNode root_node;

    //region 定义添加结点的方法
    public void addNode(TreeNode new_node) {
        //如果根结点为空, 新结点直接成为根结点
        if (root_node == null) {
            root_node = new_node;
        }
        //如果根结点不为空, 则根结点调用增加结点方法
        else {
            root_node.addNode(new_node);
        }
    }
    //endregion

    //region 定义中序遍历方法
    public void infixOrder(){
        if(root_node == null){
            System.out.println("the tree is null!");
            return;
        }
        root_node.infixOrder();
    }
    //endregion
}
