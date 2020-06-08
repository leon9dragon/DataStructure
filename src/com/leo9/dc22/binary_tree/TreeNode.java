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

    //计数器
    public static int preCount = 0;
    //前序查找方法
    public TreeNode preSearch(int target_no){
        //创建一个临时变量用以接收目标节点
        TreeNode target = null;
        //在比较前计数器加一
        preCount++;
        System.out.printf("the preCount is [%d]\n", preCount);
        //先判断当前节点的 no 是否和目标 no 相等
        if (this.person_no == target_no){
            target = this;
        }
        //不相等, 则进入下面的判断
        else{
            //如果当前节点的左子节点不为空, 则递归前序查找
            if(this.left_node != null){
                target = this.left_node.preSearch(target_no);
            }
            //如果当前节点的右子节点不为空, 则递归前序查找
            //target 非空说明找到目标, 直接跳过即可
            if (target == null && this.right_node != null){
                target = this.right_node.preSearch(target_no);
            }
        }
        //如果当前节点的左右节点都不符合或者没有左右子节点, 则返回默认值 null
        return target;
    }

    //计数器
    public static int infixCount = 0;
    //中序查找方法
    public TreeNode infixSearch(int target_no){
        //创建一个临时变量用以接收目标节点
        TreeNode target = null;

        //如果当前节点的左子节点不为空, 则递归中序查找
        if (this.left_node != null){
            target = this.left_node.infixSearch(target_no);
        }

        //在比较前计数器加一
        infixCount++;
        System.out.printf("the infixCount is [%d]\n", infixCount);
        //判断当前节点的 no 是否和目标 no 相等
        //target 非空说明找到目标, 直接跳过即可
        if(target == null && this.person_no == target_no){
            target = this;
        }

        //如果当前节点的右子节点不为空, 则递归中序查找
        //target 非空说明找到目标, 直接跳过即可
        if (target == null && this.right_node != null){
            target = this.right_node.infixSearch(target_no);
        }
        return target;
    }

    //计数器
    public static int postCount = 0;
    //后序查找方法
    public TreeNode postSearch(int target_no){
        //创建一个临时变量用以接收目标节点
        TreeNode target = null;

        //如果当前节点的左子节点不为空, 则递归中序查找
        if (this.left_node != null){
            target = this.left_node.postSearch(target_no);
        }

        //如果当前节点的右子节点不为空, 则递归中序查找
        //target 非空说明找到目标, 直接跳过即可
        if (target == null && this.right_node != null){
            target = this.right_node.postSearch(target_no);
        }

        //在比较前计数器加一
        postCount++;
        System.out.printf("the postCount is [%d]\n", postCount);
        //判断当前节点的 no 是否和目标 no 相等
        //target 非空说明找到目标, 直接跳过即可
        if(target == null && this.person_no == target_no){
            target = this;
        }

        return target;
    }
}
