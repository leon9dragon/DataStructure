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
        map[5][2] = 1;
        map[6][2] = 1;

        //输出地图
        System.out.println("===============before=============");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //开始寻路
        setWay(map,1,1);

        //输出地图
        System.out.println("===============after=============");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //region 使用递归回溯来给小球找路
    /*
    * @description:
    *   (1) map表示地图
    *   (2) i,j 表示从地图的哪个位置出发, 从(1,1)左上角出发
    *   (3) 如果小球能到map[6][5]位置, 则说明有通路
    *   (4) 约定: 当map[i][j]的值为0表示改点没有走过, 为1表示墙,
    *             为2表示通路可走, 为3表示该点走过但走不通.
    *   (5) 在走迷宫时需要确定策略(方法), 下->右->上->左, 如果该点走不通, 则回溯
    * @param: map 表示地图
    * @param: i 初始位置的行号
    * @param: j 初始位置的列号
    * @return: 如果找到通路返回true, 找不到则返回false
    */
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][1] == 2){
            //当终点为2时说明走通了
            return true;
        }
        else{
            if(map[i][j] == 0){
                //如果当前点没有走过, 则按照策略 下->右->上->左 的方式走
                //先假定该点可以走通
                map[i][j] = 2;
                if(setWay(map, i + 1, j)){
                    //在这个点基础下向下走, 行数i + 1
                    return true;
                }

                else if(setWay(map, i, j + 1)){
                    //在这个点基础下向右走, 列数j + 1
                    return true;
                }

                else if(setWay(map, i - 1, j)){
                    //在这个点基础下向上走, 列数i - 1
                    return true;
                }

                else if(setWay(map, i, j - 1)){
                    //在这个点基础下向左走, 列数j - 1
                    return true;
                }
                
                else {
                    //如果以上4个条件都不成立, 将该点置成3, 并返回false
                    map[i][j] = 3;
                    return false;
                }
            }
            else{
                //如果map[i][j] != 0, 可能为1, 2, 3
                return false;
            }
        }
    }
    //endregion
}
