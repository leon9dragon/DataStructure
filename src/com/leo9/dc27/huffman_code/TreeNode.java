package com.leo9.dc27.huffman_code;
//创建结点类, 用以存放每个字符的数据
public class TreeNode implements Comparable<TreeNode>{
    //存放字符的数据
    Byte char_data;
    //存放字符的出现次数, 即结点的权值
    int char_weight;
    //定义左右子结点
    TreeNode left_node;
    TreeNode right_node;

    //定义构造函数
    public TreeNode(Byte char_data, int char_weight) {
        this.char_data = char_data;
        this.char_weight = char_weight;
    }

    @Override
    //定义排序
    public int compareTo(TreeNode o) {
        //从小到大排序
        return this.char_weight - o.char_weight;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "char_data=" + char_data +
                ", char_weight=" + char_weight +
                '}';
    }

    //前序遍历结点
    public void preOrder(){
        System.out.println(this);
        if(this.left_node != null){
            this.left_node.preOrder();
        }
        if(this.right_node != null){
            this.right_node.preOrder();
        }
    }
}
