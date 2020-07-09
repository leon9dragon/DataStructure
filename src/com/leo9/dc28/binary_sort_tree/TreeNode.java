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

    //region 查找要删除的结点

    /**
     * @param node_val 目标结点的value值
     * @return 如果找到目标结点, 则返回目标结点, 否则返回null
     */
    public TreeNode searchTargetNode(int node_val) {
        //与当前调用节点的值进行比较
        //如果相等, 就返回当前调用结点
        if (node_val == this.value) {
            return this;
        }
        //如果小于当前调用结点的值, 则用当前结点的左子结点进行调用查找方法
        else if (node_val < this.value) {
            if (this.left_node != null) {
                return this.left_node.searchTargetNode(node_val);
            } else {
                System.out.println("the target node is not existed!");
                return null;
            }
        }
        //如果大于当前调用结点的值, 则用当前结点的右子结点进行调用查找方法
        else {
            if (this.right_node != null) {
                return this.right_node.searchTargetNode(node_val);
            } else {
                System.out.println("the target node is not existed!");
                return null;
            }
        }
    }
    //endregion

    //region 查找目标结点的父结点

    /**
     * @param node_val 目标结点本身的value值
     * @return 要返回的目标结点的父结点, 如果没有则返回null
     */
    public TreeNode searchParentNode(int node_val) {
        //如果当前结点的左(右)子结点不为空, 且它的左(右)子结点的值就等于目标值, 则当前结点是父结点
        if ((this.left_node != null && this.left_node.value == node_val) || (this.right_node != null && this.right_node.value == node_val)) {
            return this;
        } else {
            //如果查找的值小于等于当前结点的值, 且当前结点的左子结点非空, 则递归向左查找
            if (this.left_node != null && node_val <= this.value) {
                return this.left_node.searchParentNode(node_val);
            }
            //如果查找的值大于当前结点的值, 且当前结点的右子结点非空, 则递归向右查找
            else if (this.right_node != null && node_val > this.value) {
                return this.right_node.searchParentNode(node_val);
            }
            //如果上述条件都不满足, 则找不到父结点
            else {
                return null;
            }
        }
    }
    //endregion
}
