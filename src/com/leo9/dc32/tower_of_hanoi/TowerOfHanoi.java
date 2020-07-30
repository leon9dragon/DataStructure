package com.leo9.dc32.tower_of_hanoi;

public class TowerOfHanoi {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    //汉诺塔的移动方案, 使用分治算法解决

    /**
     * @param plate_num 盘子的数量
     * @param pillar_a  柱子A
     * @param pillar_b  柱子B
     * @param pillar_c  柱子C
     */
    public static void hanoiTower(int plate_num, char pillar_a, char pillar_b, char pillar_c) {
        //如果盘子数量等于一
        if (plate_num == 1) {
            System.out.printf("第[1]个盘从塔[%c]->塔[%c]\n", pillar_a, pillar_c);
        }
        //如果盘数大于等于二
        else {
            //1. 先把最上面的所有盘 A->B, 移动过程会用到C塔
            hanoiTower(plate_num - 1, pillar_a, pillar_c, pillar_b);
            //2. 把最下边的底盘 A->C
            System.out.printf("第[%d]个盘从塔[%c]->塔[%c]\n", plate_num, pillar_a, pillar_c);
            //3. 把B塔剩下的所有盘移动到C塔, 移动过程中会用到A塔
            hanoiTower(plate_num - 1, pillar_b, pillar_a, pillar_c);
        }
    }
}
