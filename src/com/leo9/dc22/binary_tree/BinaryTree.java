package com.leo9.dc22.binary_tree;

//创建二叉树类. 主要用于存放根节点.
public class BinaryTree {
    //成员只需定义根节点即可, 节点相关操作实际由节点类完成
    private TreeNode root_node;
    //定义设置根节点的方法
    public void setRoot_node(TreeNode root_node) {
        this.root_node = root_node;
    }
    public void setRoot_node(int person_no, String person_name) {
        root_node = new TreeNode(person_no, person_name);
    }

    //二叉树前序遍历
    public void preOrder(){
        if(this.root_node != null){
            this.root_node.preOrder();
        }
    }
    //二叉树中序遍历
    public void infixOrder(){
        if(this.root_node != null){
            this.root_node.infixOrder();
        }
    }
    //二叉树后序遍历
    public void postOrder(){
        if(this.root_node != null){
            this.root_node.postOrder();
        }
    }

    //二叉树前序查找
    public void preSearch(int target_no){
        if(this.root_node != null){
            TreeNode target = this.root_node.preSearch(target_no);
            if (target != null){
                System.out.printf("The target[no=%d] found which is %s\n", target_no, target.toString());
            }
            else {
                System.out.printf("Can't found the target[no=%d]\n", target_no);
            }
        }
    }

    //二叉树中序查找
    public void infixSearch(int target_no){
        if(this.root_node != null){
            TreeNode target = this.root_node.infixSearch(target_no);
            if (target != null){
                System.out.printf("The target[no=%d] found which is %s\n", target_no, target.toString());
            }
            else {
                System.out.printf("Can't found the target[no=%d]\n", target_no);
            }
        }
    }

    //二叉树后序查找
    public void postSearch(int target_no){
        if(this.root_node != null){
            TreeNode target = this.root_node.postSearch(target_no);
            if (target != null){
                System.out.printf("The target[no=%d] found which is %s\n", target_no, target.toString());
            }
            else {
                System.out.printf("Can't found the target[no=%d]\n", target_no);
            }
        }
    }
}