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
    public void infixOrder() {
        if (root_node == null) {
            System.out.println("the tree is null!");
            return;
        }
        root_node.infixOrder();
    }
    //endregion

    //region 查找目标结点方法
    public TreeNode searchTargetNode(int node_val) {
        if (root_node == null) {
            System.out.println("the root node is null!");
            return null;
        } else {
            return root_node.searchTargetNode(node_val);
        }
    }
    //endregion

    //region 查找父结点方法
    public TreeNode searchParentNode(int node_val) {
        if (root_node == null) {
            System.out.println("the root node is null!");
            return null;
        } else {
            return root_node.searchParentNode(node_val);
        }
    }
    //endregion

    //region 删除结点方法
    public void delTargetNode(int node_val) {
        if (root_node == null) {
            System.out.println("the root node is null!");
            return;
        } else {
            //region 先判断目标节点是否存在并且其父结点是否存在
            //1.需要先找到要删除的目标结点是否存在
            TreeNode target_node = searchTargetNode(node_val);
            if (target_node == null) {
                return;
            }

            //2.若target_node存在则查找target_node的父结点是否存在
            //2.1.如果target_node就是根节点
            if(node_val == root_node.value){
                root_node = null;
            }
            //2.2.若target_node非根节点, 则调用查找父结点方法
            TreeNode parent_node = root_node.searchParentNode(node_val);

            //endregion

            //region 情况1: 删除的是叶子结点
            

            //endregion
        }
    }
    //endregion
}
