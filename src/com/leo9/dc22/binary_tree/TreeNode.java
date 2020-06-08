package com.leo9.dc22.binary_tree;

//创建节点类, 用来存放节点信息和节点的左右子节点信息
public class TreeNode {
    //节点存放的信息
    private int person_no;
    private String person_name;

    //节点的子节点
    private TreeNode left_node;
    private TreeNode right_node;

    //节点构造器
    public TreeNode(int person_no, String person_name) {
        this.person_no = person_no;
        this.person_name = person_name;
    }

    //节点成员的getter和setter方法
    public int getPerson_no() {
        return person_no;
    }

    public void setPerson_no(int person_no) {
        this.person_no = person_no;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public TreeNode getLeft_node() {
        return left_node;
    }

    public void setLeft_node(TreeNode left_node) {
        this.left_node = left_node;
    }

    public TreeNode getRight_node() {
        return right_node;
    }

    public void setRight_node(TreeNode right_node) {
        this.right_node = right_node;
    }

    //重载节点的toString方法
    @Override
    public String toString() {
        return "TreeNode{" +
                "person_no=" + person_no +
                ", person_name='" + person_name + '\'' +
                '}';
    }

    //前序遍历方法
    public void preOrder(){
        //先输出当前节点
        System.out.println(this);
        //然后递归向左子树
        if (this.left_node != null){
            this.left_node.preOrder();
        }
        //再递归向右子树
        if (this.right_node != null){
            this.right_node.preOrder();
        }
    }

    //中序遍历方法
    public void infixOrder(){
        //先递归向左子树
        if(this.left_node != null){
            this.left_node.infixOrder();
        }
        //再输出当前节点
        System.out.println(this);
        //再递归向右子树
        if (this.right_node != null){
            this.right_node.infixOrder();
        }
    }

    //后续遍历方法
    public void postOrder(){
        //先递归向左子树
        if(this.left_node != null){
            this.left_node.infixOrder();
        }
        //再递归向右子树
        if (this.right_node != null){
            this.right_node.infixOrder();
        }
        //再输出当前节点
        System.out.println(this);
    }
}
