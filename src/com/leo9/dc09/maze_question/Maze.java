package com.leo9.dc09.maze_question;

public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组, 用以模拟迷宫地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for(int i = 0; i < 8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板, 用1表示
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    
}
