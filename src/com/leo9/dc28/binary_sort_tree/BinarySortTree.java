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
            if (node_val == root_node.value) {
                root_node = null;
            }
            //2.2.若target_node非根节点, 则调用查找父结点方法
            TreeNode parent_node = root_node.searchParentNode(node_val);

            //endregion

            //region 情况1: 删除的是叶子结点
            //如果目标结点的左右子结点都为空, 可以确定它为叶子结点
            if (target_node.left_node == null && target_node.right_node == null) {
                //判断目标结点是父结点的左子结点还是右子结点
                //如果目标结点是父结点的左子结点
                if (parent_node.left_node != null && parent_node.left_node.value == node_val) {
                    parent_node.left_node = null;
                }
                //如果目标结点是父结点的右子结点
                if (parent_node.right_node != null && parent_node.right_node.value == node_val) {
                    parent_node.right_node = null;
                }
            }

            //endregion

            //region 情况3: 删除的是有两个子结点的结点
            //情况3提前是为了少些判断条件, 将剩余情况归类于情况2
            else if (target_node.left_node != null && target_node.right_node != null) {
                //取得右子树最小权值结点的权值, 并在二叉树中删除这个最小权值结点
                int right_min_val = delRightTreeMinNode(target_node);
                //将目标删除结点的权值替换成这个最小权值结点的权值, 即可完成对目标结点的删除
                target_node.value = right_min_val;
            }
            //endregion

            //region 情况2: 删除的是有一个子结点的结点
            else {
                //如果要删除的目标结点有左子结点
                if (target_node.left_node != null) {
                    //如果目标结点是其父结点的左子结点
                    if (parent_node.left_node.value == node_val) {
                        parent_node.left_node = target_node.left_node;
                    }
                    //如果目标结点是其父结点的右子结点
                    else {
                        parent_node.right_node = target_node.left_node;
                    }
                }
                //如果要删除的目标结点有右子结点
                else {
                    //如果目标结点是其父结点的左子结点
                    if (parent_node.left_node.value == node_val) {
                        parent_node.left_node = target_node.right_node;
                    }
                    //如果目标结点是其父结点的右子结点
                    else {
                        parent_node.right_node = target_node.right_node;
                    }
                }
            }
            //endregion
        }
    }
    //endregion

    //region 寻找调用结点右子树下的权值最小结点, 保存其权值并删除结点, 最后返回这个最小权值
    //注意: 是查找以目标结点的右子结点为根节点的右子树下的最小权值结点
    //      因此这棵右子树的最左的叶子结点就是最小权值节点
    public int delRightTreeMinNode(TreeNode the_node) {
        //定义临时结点用以存储最小结点, 后续循环进行替换
        //先假定最小结点是调用结点的右子结点, 即右子树的根节点
        TreeNode min_node = the_node.right_node;
        //循环查找左子结点, 找到最小权值的左子结点
        while (min_node.left_node != null) {
            min_node = min_node.left_node;
        }
        //然后在二叉树中删除这个结点
        delTargetNode(min_node.value);
        //最后返回这个右子树下的最小最小权值
        return min_node.value;
    }
    //endregion
}
