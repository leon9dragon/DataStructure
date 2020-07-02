package com.leo9.dc27.huffman_code;

import javafx.print.Collation;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String sample_str = "i like like like java do you like a java";
        //获取示例字符串的字节数组
        byte[] byte_arr = sample_str.getBytes();
        System.out.println("====================================");
        System.out.println("the byte array length:" + byte_arr.length);
        List<TreeNode> node_list = getNodes(byte_arr);
        System.out.println("====================================");
        System.out.println("the node list:" + node_list);
    }

    //定义获取结点方法
    private static List<TreeNode> getNodes(byte[] bytes) {
        //1. 创建一个ArrayList, 存放结点列表
        ArrayList<TreeNode> node_list = new ArrayList<TreeNode>();

        //2. 遍历byte_arr, 统计每个byte出现的次数, 用map来处理
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                //Map还没有这个字符数据, 第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //3. 遍历Map并将Map中的每个键值对转换成TreeNode对象, 并加入到node_list中
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            node_list.add(new TreeNode(entry.getKey(), entry.getValue()));
        }

        return node_list;
    }

    //定义根据List来创建哈夫曼树的方法
    private static TreeNode createHuffmanTreeByList(List<TreeNode> nodes) {
        while (nodes.size() > 1) {
            //从小到大排序
            Collections.sort(nodes);
            //取出第一棵最小的二叉树
            TreeNode leftNode = nodes.get(0);
            //取出第二棵最小的二叉树
            TreeNode rightNode = nodes.get(1);
            //创建一棵新的二叉树, 注意它只有叶子结点有 char_data 其它没有.
            TreeNode parentNode = new TreeNode(null, leftNode.char_weight + rightNode.char_weight);
            parentNode.left_node = leftNode;
            parentNode.right_node = rightNode;
            //将已经处理的二叉树从结点列表中删除, 并将新的二叉树加入列表
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }

        //返回哈夫曼树的根结点
        return nodes.get(0);
    }
}
