package com.leo9.dc29.avl_tree;

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

        /**----------新增部分-----------*/
        //region 判断是否需要左旋转
        //如果 (右子树高度-左子树高度) > 1, 进行左旋转
        if (getRightHeight() - getLeftHeight() > 1) {
            //如果它的右子树的左子树高度大于它的右子树的右子树高度
            //则先对右子树进行一次右旋转, 再执行对二叉树本身的左旋转
            if (right_node != null && right_node.getLeftHeight() > right_node.getRightHeight()) {
                right_node.rightRotate();
            }
            leftRotate();
            return;
        }
        //endregion

        //region 判断是否需要右旋转
        //如果 (左子树高度-右子树高度) > 1, 进行右旋转
        if (getLeftHeight() - getRightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的左子树高度
            //则先对左子树进行一次左旋转, 再执行对二叉树本身的右旋转
            if (left_node != null && left_node.getRightHeight() > left_node.getLeftHeight()) {
                left_node.leftRotate();
            }
            rightRotate();
            return;
        }
        //endregion
        /**----------------------*/
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

    /**
     * -------------以下是新增部分--------------
     */
    //region 返回以当前结点为根节点的树的高度
    public int getHeight() {
        //递归调用方法获取最大的树的高度, 末尾加一是因为本身结点自己算一层
        return Math.max(left_node == null ? 0 : left_node.getHeight(), right_node == null ? 0 : right_node.getHeight()) + 1;
    }
    //endregion

    //region 返回左子树的高度
    public int getLeftHeight() {
        if (left_node == null) {
            return 0;
        }
        return left_node.getHeight();
    }
    //endregion

    //region 返回右子树的高度
    public int getRightHeight() {
        if (right_node == null) {
            return 0;
        }
        return right_node.getHeight();
    }
    //endregion

    //region 左旋转排序二叉树, 转换为平衡二叉树
    private void leftRotate() {
        //当前结点是根节点, 该方法在增加结点方法中被调用,
        //而在二叉树类中封装好的新增结点方法是由根结点调用的
        //创建新的结点, 以当前节点的权值创建
        TreeNode new_node = new TreeNode(value);
        //把新的结点的左子结点设置成当前结点的左子结点
        new_node.left_node = left_node;
        //把新结点的右子结点设置成当前结点的右子结点的左子结点
        new_node.right_node = right_node.left_node;
        //把当前结点的值替换成其右子结点的值
        value = right_node.value;
        //把当前结点的右子结点设置成当前结点的右子结点的右子结点
        right_node = right_node.right_node;
        //把当前结点的左子结点设置为前面定义的新结点
        left_node = new_node;
    }
    //endregion

    //region 右旋转排序二叉树, 转换为平衡二叉树
    private void rightRotate() {
        //当前结点是根节点, 该方法在增加结点方法中被调用,
        //而在二叉树类中封装好的新增结点方法是由根结点调用的
        TreeNode new_node = new TreeNode(value);
        new_node.right_node = right_node;
        new_node.left_node = left_node.right_node;
        value = left_node.value;
        left_node = left_node.left_node;
        right_node = new_node;
    }
    //endregion
}

