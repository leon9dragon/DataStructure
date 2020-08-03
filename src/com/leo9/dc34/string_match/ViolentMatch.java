package com.leo9.dc34.string_match;

public class ViolentMatch {
    public static void main(String[] args) {
        String str1 = "ababcabcacbab";
        String str2 = "abcac";
        int res_of_match = violentMatch(str1, str2);
        if (res_of_match == -1) {
            System.out.println("===============================");
            System.out.println("failed to match!");
        } else {
            System.out.println("===============================");
            System.out.printf("the first place match str2[\"%s\"] with str1[\"%s\"] is [%d].\n", str2, str1, res_of_match);
        }

    }

    public static int violentMatch(String str1, String str2) {
        //将字符串转化为字符数组
        char[] str1_array = str1.toCharArray();
        char[] str2_array = str2.toCharArray();

        //获取字符串的长度
        int str1_length = str1_array.length;
        int str2_length = str2_array.length;

        //定义两个索引分别指向两个字符串
        int str1_index = 0;
        int str2_index = 0;

        //开始循环匹配, 索引没有越界就一直循环
        while (str1_index < str1_length && str2_index < str2_length) {
            //当前字符匹配成功, 索引自加后移
            if (str1_array[str1_index] == str2_array[str2_index]) {
                str1_index++;
                str2_index++;
            }
            //当前字符匹配失败, str1的索引回溯并后移一位, str2的索引重置为零
            else {
                str1_index = str1_index - str2_index + 1;
                str2_index = 0;
            }
        }
        //根据 str2 的索引的位置来判断字符串匹配是否成功完成
        if (str2_index == str2_length) {
            //匹配成功则返回第一次str2在str1中出现的位置
            return str1_index - str2_index;
        }
        //匹配失败则返回 -1
        return -1;
    }
}
