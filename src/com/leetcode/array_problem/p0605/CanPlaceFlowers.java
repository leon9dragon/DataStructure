package com.leetcode.array_problem.p0605;



import java.util.Arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {0, 0, 0, 0, 0};
        int n = 4;
        System.out.println("============================");
        System.out.println("the array = " + Arrays.toString(flowerbed));
        System.out.printf("the new flowers nuber is [%d]\n", n);
        boolean res = canPlaceFlowers(flowerbed, n);

        if (res) {
            System.out.println("the plots are enough!");
        } else {
            System.out.println("the plots are not enough!");
        }
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int place = 0;
        int sign;

        for (sign = 0; sign < flowerbed.length; sign++) {
            if (flowerbed[sign] == 0) {
                count++;
            } else {
                break;
            }
        }

        if (count != 0) {
            if (count == flowerbed.length) {
                count = count % 2 == 0 ? count - 1 : count;
                place = count / 2 + 1;
            } else {
                place += count / 2;
            }
            count = 0;
        }


        for (int i = sign; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                if (count != 0) {
                    count = count % 2 == 0 ? count - 1 : count;
                    place += count / 2;
                    count = 0;
                }
            }
        }

        if (count != 0) {
            place += count / 2;
        }

        System.out.printf("the number of places can be placed flower is [%d]\n", place);

        return place >= n;
    }
}
