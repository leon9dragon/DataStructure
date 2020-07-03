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
        System.out.println("the node list:\n" + node_list);

        TreeNode huffman_tree_root = createHuffmanTreeByList(node_list);
        System.out.println("====================================" + "\npre order huffman tree:");
        huffman_tree_root.preOrder();

        System.out.println("====================================");
        Map<Byte,String> the_huffman_code = getHuffmanCode(huffman_tree_root);
        System.out.println("the huffman code is:\n" + the_huffman_code);

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

    //生成哈夫曼树对应的哈夫曼编码的过程
    //1. 将哈夫曼编码存放在一个Map当中, Map<Byte, String>
    //   形如 [32->01, 97->100, 100->11000]
    static Map<Byte, String> huffman_code = new HashMap<Byte, String>();

    //2. 在生成哈夫曼编码表时, 需要去拼接路径, 定义StringBuilder存放某个叶子结点的路径
    static StringBuilder leave_node_code = new StringBuilder();

    //3. 定义方法获取传入的哈夫曼树的根结点下的所有叶子结点的哈夫曼编码并放入到huffman_code中

    /**
     * @param node            传入的哈夫曼树结点
     * @param code            路径值, 左子结点为0, 右子结点为1
     * @param leave_node_code 用于拼接路径
     */
    private static void getHuffmanCode(TreeNode node, String code, StringBuilder leave_node_code) {
        StringBuilder build_code = new StringBuilder(leave_node_code);
        //将code加入到build_code
        build_code.append(code);

        //判断结点是否为空, 为空则不处理
        if (node != null) {
            //判断当前节点是叶子结点还是非叶子结点
            if (node.char_data == null) {
                //如果是非叶子结点, 就开始继续递归
                //向左递归
                getHuffmanCode(node.left_node, "0", build_code);
                //向右递归
                getHuffmanCode(node.right_node, "1", build_code);
            } else {
                //如果是叶子结点, 表示该叶子结点对应的字符的编码已经完成
                //将该叶子结点对应的字符数据和编码值转换成的字符串存入huffman_code即可
                huffman_code.put(node.char_data, build_code.toString());
            }
        }
    }

    //封装上述流程, 使调用更方便
    private static Map<Byte, String> getHuffmanCode(TreeNode the_root) {
        if (the_root == null) {
            return null;
        }
        getHuffmanCode(the_root, "", leave_node_code);
        return huffman_code;
    }
}
