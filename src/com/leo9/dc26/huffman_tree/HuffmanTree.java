package com.leo9.dc26.huffman_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//创建哈夫曼树类
public class HuffmanTree {
    public static void main(String[] args) {
        //创建示例数组
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        createHuffmanTree(arr).preOrder();
    }

    /**
     * @function 创建哈夫曼树方法
     * @param arr 传入的目标数组
     * @return 返回的是哈夫曼树的根结点
     * */
    public static TreeNode createHuffmanTree(int[] arr) {
        //1.为了操作方便, 先遍历数组
        //2.将数组每个元素都转化为结点元素
        //3.将转化得到的结点元素全部放入ArrayList中

        //创建结点列表
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        //遍历数组, 转化结点并存入结点列表
        for (int value : arr) {
            nodeList.add(new TreeNode(value));
        }

        //往复循环排序结点列表和构建二叉树, 最终得到的结点列表只保留了哈夫曼树的根结点
        while (nodeList.size()>1){
            //4.列表排序后, 取出根结点权值最小的两棵二叉树, 并构建新的二叉树
            //4.0.先从小到大对结点列表进行排序
            Collections.sort(nodeList);
            //4.1.取出最小的结点
            TreeNode left_node = nodeList.get(0);
            //4.2.取出次小的结点
            TreeNode right_node = nodeList.get(1);
            //4.3.构建新二叉树根结点, 并连接上面俩结点
            TreeNode root_node = new TreeNode(left_node.value + right_node.value);
            root_node.left_node = left_node;
            root_node.right_node = right_node;

            //5.重新整理结点列表
            //5.1.先去除掉已经连接上的两个最小结点
            nodeList.remove(left_node);
            nodeList.remove(right_node);
            //5.2.再将得到的新的二叉树根结点放入列表
            nodeList.add(root_node);
        }
        return nodeList.get(0);
    }
}
