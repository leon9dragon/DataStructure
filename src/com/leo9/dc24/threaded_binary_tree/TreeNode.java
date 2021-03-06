package com.leo9.dc24.threaded_binary_tree;


//创建结点类, 用来存放结点信息和结点的左右子结点信息
public class TreeNode {
    //节点存放的信息
    private int person_no;
    private String person_name;

    //节点的子节点
    private TreeNode left_node;
    private TreeNode right_node;

    //结点的指针属性
    //如果left_type == 0 表示左指针指向的是左子树, 如果为 1 则指向前驱结点
    //如果right_type == 0 表示右指针指向的是右子树, 如果为 1 则指向后继结点
    private int left_type;
    private int right_type;

    //节点构造器
    public TreeNode(int person_no, String person_name) {
        this.person_no = person_no;
        this.person_name = person_name;
    }

    //节点成员的getter和setter方法

    public int getLeft_type() {
        return left_type;
    }

    public void setLeft_type(int left_type) {
        this.left_type = left_type;
    }

    public int getRight_type() {
        return right_type;
    }

    public void setRight_type(int right_type) {
        this.right_type = right_type;
    }

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

    //删除结点方法
    public boolean delNode(int target_no){
        //如果当前结点的左子结点不为空且是要删除的结点,
        //直接将其左子结点置空为 null 即可, 并返回结束递归.
        if(this.left_node != null && this.left_node.person_no == target_no){
            this.left_node = null;
            return true;
        }

        //如果当前结点的右子结点不为空且是要删除的结点,
        //直接将其右子结点置空为 null 即可, 并返回结束递归.
        if(this.right_node != null && this.right_node.person_no == target_no){
            this.right_node = null;
            return true;
        }

        boolean res = false;
        //上述步骤都没有删除结点, 则向左子树进行递归删除
        if(this.left_node != null){
            res = this.left_node.delNode(target_no);
            if(res){
                return res;
            }
        }

        //向左递归没有删除结点, 则向右子树进行递归删除
        if(this.right_node != null){
            res = this.right_node.delNode(target_no);
            if(res){
                return res;
            }
        }

        //如果都没有删除结点, 则结点并不存在, 删除失败
        return false;
    }
}