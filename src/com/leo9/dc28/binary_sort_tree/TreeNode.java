package com.leo9.dc28.binary_sort_tree;

public class TreeNode {
    public int value;
    public TreeNode left_node;
    public TreeNode right_node;

    public TreeNode(int value) {
        this.value = value;
    }

    //region 添加结点的方法
    //递归形式添加结点, 注意需要满足二叉排序树的要求
    public void addNode(TreeNode new_node) {
        //若传入空结点则直接返回即可
        if (new_node == null) {
            return;
        }

        //region 判断传入的结点的值, 和当前调用方法的结点的值关系
        //如果新结点的值小于等于当前调用结点的值
        if (new_node.value <= this.value) {
            //如果当前调用结点的左子结点为空, 则直接将新结点接在其左子结点即可
            if (this.left_node == null) {
                this.left_node = new_node;
            }
            //如果不为空, 递归向左添加
            else {
                this.left_node.addNode(new_node);
            }
        }
        //如果新结点的值大于当前调用结点的值
        else {
            //如果当前调用结点的右子结点为空, 则直接将新结点接在其右子结点即可
            if (this.right_node == null) {
                this.right_node = new_node;
            }
            //如果不为空, 递归向右添加
            else {
                this.right_node.addNode(new_node);
            }
        }
        //endregion
    }
    //endregion


    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    //region 中序遍历
    public void infixOrder() {
        if (this.left_node != null) {
            this.left_node.infixOrder();
        }

        System.out.println(this);

        if (this.right_node != null) {
            this.right_node.infixOrder();
        }
    }
    //endregion
}
