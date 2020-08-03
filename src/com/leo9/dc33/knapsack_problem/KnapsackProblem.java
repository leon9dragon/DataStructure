package com.leo9.dc33.knapsack_problem;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        //定义数组保存物品的重量
        int[] good_weight = {1, 4, 3};
        //定义数组保存物品的价值
        int[] good_value = {1500, 3000, 2000};
        //定义背包的容量
        int max_capacity = 4;
        //定义物品的个数, 直接获取上述任意数组长度即可
        int good_amount = good_weight.length;

        //定义一个对应的二维数组, 保存商品存放情况
        int[][] store_path = new int[good_amount + 1][max_capacity + 1];

        //创建二维数组, 表示分治表.
        //value_sheet[i][j] 的含义是:
        //表示前 i 个物品中能够放入容量为 j 的背包中的最大价值
        int[][] value_sheet = new int[good_amount + 1][max_capacity + 1];

        //初始化分治表第一行和第一列, 如果初始化为 0 可以不写, 以下展示过程;
        //第一行对应的是 0 个物品可选时的背包价值, 都为 0
        //第一列对应的是背包容量为 0 时的背包价值, 都为 0
        for (int i = 0; i < max_capacity; i++) {
            //第一行
            value_sheet[0][i] = 0;
        }
        for (int i = 0; i < good_amount; i++) {
            //第一列
            value_sheet[i][0] = 0;
        }

        //根据公式进行动态规划处理
        //第一层循环是抓取的行数, 但不处理第一行, 第一行已经初始化定义了
        //第二层循环是抓取的列数, 但不处理第一列, 第一列也已经初始化定义
        //因此临时变量 i 和 j 都是从 1 开始的.
        for (int i = 1; i < value_sheet.length; i++) {
            for (int j = 1; j < value_sheet[0].length; j++) {
                //程序中的 i 对应的是二维数组, 要与一维数组对应需要减一
                if (good_weight[i - 1] > j) {
                    value_sheet[i][j] = value_sheet[i - 1][j];
                } else {
                    //value_sheet[i][j] = Math.max(value_sheet[i - 1][j], good_value[i - 1] + value_sheet[i - 1][j - good_weight[i - 1]]);
                    //因为要记录商品存放情况, 不能用上面公式进行简单取值, 改为 if..else..形式
                    //用两个变量存储上一最优解和当前选择的价值
                    int last_choice = value_sheet[i - 1][j];
                    int now_choice = good_value[i - 1] + value_sheet[i - 1][j - good_weight[i - 1]];
                    //开始判断当前选择的价值和上一最优解的大小
                    //选出最大价值在分治表中进行记录, 并在另一张表中记录下存储的商品的编号
                    if (last_choice < now_choice) {
                        value_sheet[i][j] = now_choice;
                        store_path[i][j] = 1;
                    } else {
                        value_sheet[i][j] = last_choice;
                    }
                }
            }
        }


        //打印表格
        for (int[] row : value_sheet) {
            System.out.println(Arrays.toString(row));
        }

        //输出最佳原目标结果, 本质上是取的几个最优解的组合
        int i = store_path.length - 1;
        int j = store_path[0].length - 1;
        while (i > 0 && j > 0) {
            if (store_path[i][j] == 1) {
                System.out.printf("put the good[%d] into knapsack\n", i);
                j -= good_weight[i - 1];
            }
            i--;
        }
    }
}
