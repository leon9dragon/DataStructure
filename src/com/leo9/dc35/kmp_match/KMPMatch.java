package com.leo9.dc35.kmp_match;

import java.util.Arrays;

public class KMPMatch {
    public static void main(String[] args) {
        String S="BBC ABCDAB ABCDABCDABDE";
        String P="ABCDABD";
        int res = matchByKMP(S,P);
        if(res != -1){
            System.out.printf("success! the position in string is [%d]\n", res);
        }else {
            System.out.println("can not match!");
        }
    }

    //定义获取 next 数组的方法
    public static int[] getNextArray(String P) {
        //先将模式串 P 转换成字符数组
        char[] char_array_P = P.toCharArray();
        //定义next数组, 长度和字符数组的长度一致, 初始化第一位为 -1
        int[] next_array = new int[char_array_P.length];
        next_array[0] = -1;
        //定义两个指针, k 指针初始化 -1, j 指针初始化 0;
        //k 指针用来可重定向的指向数组位与 j 指针指向位进行比较
        //j 指针用于逐位后移指向数组每一位与 k 指针指向位进行比较
        int pointer_k = -1;
        int pointer_j = 0;
        //开始循环比较, j 要小于字符数组长度减一, 防止越界, 因为 j 是先自增再被用于 next 数组赋值
        while (pointer_j < char_array_P.length - 1) {
            //当指针 k 的指向为 -1 或模式串中 P[k] == P[j] 时
            if (pointer_k == -1 || char_array_P[pointer_k] == char_array_P[pointer_j]) {
                pointer_k++;
                pointer_j++;
                next_array[pointer_j] = pointer_k;
            }
            //当以上两个条件不符合的时候, k 指针需要重定向
            else {
                pointer_k = next_array[pointer_k];
            }
        }
        //最终返回 next 数组
        return next_array;
    }

    //定义KMP算法匹配字符串
    public static int matchByKMP(String S, String P) {
        //获取 next 数组
        int[] next_array = getNextArray(P);

        //先将字符串都转换成字符数组
        char[] char_array_S = S.toCharArray();
        char[] char_array_P = P.toCharArray();

        //定义两个指针, i 和 j 初始化都为 0
        int pointer_i = 0;
        int pointer_j = 0;

        //开始循环进行匹配, 循环条件是 i 小于文本串字符数组 S 的长度
        //以及 j 小于模式串字符数组 P 的长度, 越界则结束
        while (pointer_i < char_array_S.length && pointer_j < char_array_P.length) {
            //如果 j = -1, 或者当前字符匹配成功, 则 i j 指针后移, 继续匹配
            if (pointer_j == -1 || char_array_S[pointer_i] == char_array_P[pointer_j]) {
                pointer_j++;
                pointer_i++;
            }
            //匹配失败, 则 j 指针需要重定位
            else {
                pointer_j = next_array[pointer_j];
            }
        }

        //最后循环结束, 如果 j 指针越界, 说明匹配成功, 则第一次匹配成功的位置就在 i 指针剪去 j 指针的地方
        if (pointer_j == char_array_P.length) {
            return pointer_i - pointer_j;
        }
        //匹配失败返回 -1
        else {
            return -1;
        }
    }
}
