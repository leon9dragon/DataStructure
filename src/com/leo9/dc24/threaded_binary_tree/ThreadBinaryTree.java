package com.leo9.dc24.threaded_binary_tree;

public class ThreadBinaryTree {
    //成员只需定义根节点即可, 节点相关操作实际由节点类完成
    private TreeNode root_node;

    //为了实现线索化, 需要创建指向当前结点的前驱结点的指针
    //在递归进行线索化时, pre_node 总是保留前一个结点
    private TreeNode pre_node = null;

    //定义设置根节点的方法
    public void setRoot_node(TreeNode root_node) {
        this.root_node = root_node;
    }
    public void setRoot_node(int person_no, String person_name) {
        root_node = new TreeNode(person_no, person_name);
    }

    //编写对二叉树实现中序线索化的方法, 需传入结点进行判断
    public void threadedNode(TreeNode node){
        //如果node==null, 不能线索化
        if(node == null){
            return;
        }
        //1.先线索化左子树
        threadedNode(node.getLeft_node());

        //2.再线索化当前结点
        //2.1.处理当前结点的前驱结点
        if(node.getLeft_node() == null){
            //如果当前结点的左指针为空, 则可以附加线索
            //让当前结点的左指针指向前驱结点
            node.setLeft_node(pre_node);
            //再让结点的左指针类型置为 1
            node.setLeft_type(1);
        }
        //2.2.处理前驱结点指向的后继结点
        if(pre_node != null &&pre_node.getRight_node() == null){
            //如果前驱结点的右指针为空, 则可以附加线索
            //让前驱结点的右指针指向它的后继结点
            pre_node.setRight_node(node);
            //再让前驱结点的右指针类型置为 1
            pre_node.setRight_type(1);
        }

        //每处理完一次当前结点, 便将前驱结点重新定向一次
        //让当前结点成为下一轮递归的结点的前驱结点
        //因为二叉树是单向的, 当前结点并不能通过自己的指针找到其上一个结点
        pre_node = node;

        //3.再线索化右子树
        threadedNode(node.getRight_node());
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

    //二叉树删除结点
    public void delNode(int target_no){
        //先判断根结点是否为空树, 如果只有一个根结点, 则二叉树是空的.
        if(root_node != null){
            //再判断根结点是否为目标删除结点
            if(root_node.getPerson_no() == target_no){
                //如果是, 则置空当前二叉树即可
                root_node = null;
            }
            else{
                boolean res = root_node.delNode(target_no);
                if(res){
                    System.out.printf("deleted the node[no=%d]!\n", target_no);
                }
                else {
                    System.out.printf("failed to delete the node[no=%d]!\n", target_no);
                }
            }
        }
        else {
            System.out.println("the root is null!");
        }
    }
}
