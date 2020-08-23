package com.leo9.knight_tour_problem;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class KnightTour {
    //定义棋盘的行和列, X 为列数, Y 为行数
    private static int X;
    private static int Y;

    //创建一个数组, 标记棋盘各个位置是否被访问过
    private static boolean is_visited[];
    //使用一个属性, 标记是否棋盘的所有位置都已被访问
    private static boolean is_finished;

    public static void main(String[] args) {
        //下面开始进行测试
        //初始化棋盘, 为 8*8 的大小
        X = 8;
        Y = 8;

        //初始化马的第一步位置
        int init_row = 1;
        int init_col = 1;

        //初始化棋盘数组和访问数组
        int[][] chess_board = new int[X][Y];
        is_visited = new boolean[X * Y];

        //测试耗时
        long begin_time = System.currentTimeMillis();
        knightTour(chess_board, init_row - 1, init_col - 1, 1);
        long finish_time = System.currentTimeMillis();

        System.out.println("===========show the time===========");
        System.out.printf("cost time = [%d]ms\n", finish_time - begin_time);

        System.out.println("===========show the board===========");
        for (int[] row : chess_board) {
            System.out.printf("%3c", '[');
            for(int data : row){
                System.out.printf("%3d", data);
            }
            System.out.printf("%3c", ']');
            System.out.println();
        }
    }

    /**
     * 根据当前位置, 计算马还能走哪些位置, 并放入到集合当中, 最多有八个位置
     *
     * @param curPoint 表示当前位置
     * @return 返回的结果是下一个位置
     */
    public static ArrayList<Point> getNextPoint(Point curPoint) {
        //创建一个 ArrayList 来存放马接下来的位置
        ArrayList<Point> point_list = new ArrayList<Point>();
        //创建一个 Point 对象, 用来接收下一个位置
        Point temp_point = new Point();

        //以当前位置的坐标进行判断, 计算出下一个位置, 判断 8 种情况
        //得到的位置没有越界出棋盘就可以加入集合当中进行备选

        // 5 号位的判断
        if ((temp_point.x = curPoint.x - 2) >= 0 && (temp_point.y = curPoint.y - 1) >= 0) {
            point_list.add(new Point(temp_point));
        }

        // 6 号位的判断
        if ((temp_point.x = curPoint.x - 1) >= 0 && (temp_point.y = curPoint.y - 2) >= 0) {
            point_list.add(new Point(temp_point));
        }

        // 7 号位的判断
        if ((temp_point.x = curPoint.x + 1) < X && (temp_point.y = curPoint.y - 2) >= 0) {
            point_list.add(new Point(temp_point));
        }

        // 0 号位的判断
        if ((temp_point.x = curPoint.x + 2) < X && (temp_point.y = curPoint.y - 1) >= 0) {
            point_list.add(new Point(temp_point));
        }

        // 1 号位的判断
        if ((temp_point.x = curPoint.x + 2) < X && (temp_point.y = curPoint.y + 1) < Y) {
            point_list.add(new Point(temp_point));
        }

        // 2 号位的判断
        if ((temp_point.x = curPoint.x + 1) < X && (temp_point.y = curPoint.y + 2) < Y) {
            point_list.add(new Point(temp_point));
        }

        // 3 号位的判断
        if ((temp_point.x = curPoint.x - 1) >= 0 && (temp_point.y = curPoint.y + 2) < Y) {
            point_list.add(new Point(temp_point));
        }

        // 4 号位的判断
        if ((temp_point.x = curPoint.x - 2) >= 0 && (temp_point.y = curPoint.y + 1) < Y) {
            point_list.add(new Point(temp_point));
        }

        return point_list;
    }

    /**
     * 完成马踏棋盘算法
     *
     * @param chess_board 棋盘数组
     * @param cur_row     马当前位置的所在行, 行下标从 0 开始计算
     * @param cur_col     马当前位置的所在列, 列下标从 0 开始计算
     * @param step_num    表示马走的第几步, 初始位置是第 1 步, 第一步由 user 指定.
     */
    private static void knightTour(int[][] chess_board, int cur_row, int cur_col, int step_num) {
        //在棋盘上记录是第几步
        chess_board[cur_row][cur_col] = step_num;

        //更新访问数组, 令当前格子访问属性为已访问
        //访问数组下标表示的是第几个格子, 格子下标从 0 开始计算
        is_visited[cur_row * X + cur_col] = true;

        //获取当前位置可以走的下一个位置的集合
        //列对应横坐标, 行对应纵坐标
        ArrayList<Point> next_point = getNextPoint(new Point(cur_col, cur_row));

        //遍历下一个位置的集合, 集合不为空就能继续遍历.
        while (!next_point.isEmpty()) {
            //从集合中取出一个可以走的位置
            Point temp_point = next_point.remove(0);
            //判断该点是否已被访问, 没有被访问过则进行递归访问, 同时步数加一.
            if (!is_visited[temp_point.y * X + temp_point.x]) {
                knightTour(chess_board, temp_point.y, temp_point.x, step_num + 1);
            }
        }

        //判断算法是否完成
        if (step_num < X * Y && !is_finished) {
            //如果步数少于棋盘格子数, 则算法没有完成
            //需要重置棋盘格子的步数状态和访问状态

            //进入这个步骤说明有两种情况
            //1. 棋盘到目前位置, 仍然没有走完, 表示棋盘不满足要求, 导致算法失败.
            //2. 棋盘处于回溯状态, 需要将格子归零, 用于下一轮重新进行递归.
            chess_board[cur_row][cur_col] = 0;
            is_visited[cur_row * X + cur_col] = false;
        } else {
            //如果完成了算法, 就将完成状态置为真
            is_finished = true;
        }
    }
}
