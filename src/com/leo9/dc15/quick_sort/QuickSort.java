package com.leo9.dc15.quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 3, 5, 6};
        sort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public static void sort(int arr[], int low, int high) {
        int start = low;//指定开始的索引
        int end = high;//指定结束的索引
        int key = arr[low];//设置比较值为
        while (end > start) {
            //从后往前比较
            while (end > start && arr[end] >= key) {
                //如果没有比关键值小的,比较下一个,直到有比关键值小的交换位置,然后又从前往后比较
                end--;
            }
            //将 arr[end] 和 arr[start] 进行交换
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //从前往后比较
            while (end > start && arr[start] <= key) {
                //如果没有比关键值大的,比较下一个,直到有比关键值大的交换位置
                start++;
            }
            //将 arr[end] 和 arr[start] 进行交换
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        //递归进行左侧快排
        if (start > low) {
            sort(arr, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        }
        //递归进行右侧快排
        if (end < high) {
            sort(arr, end + 1, high);//右边序列。从关键值索引+1 到最后一个
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}