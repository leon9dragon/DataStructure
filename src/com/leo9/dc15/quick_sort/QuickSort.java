package com.leo9.dc15.quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {11, 2, 6, 8, 47, 12, 96, 34};
        System.out.println("Origin Array -> " + Arrays.toString(arr));
        sortArray(arr, 0, arr.length - 1);
        System.out.println("Sorted Array -> " + Arrays.toString(arr));
    }

    public static void sortArray(int[] arr, int low, int high){
        //指定开始结束指针
        int start = low;
        int end = high;
        //指定key值
        int key = arr[(low + high)/2];
        //指定临时变量, 用于交换的时候用
        int temp;

        //开始循环, 当开始指针在结束指针后面时执行
        while(end > start){
            //开始指针向下移动
            while(arr[start] < key){
                start ++;
            }
            //结束指针向上移动
            while(arr[end] > key){
                end --;
            }
            //当开始结束指针相等或交错的时候跳出循环
            if(end <= start){
                break;
            }
            else {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end --;
                start ++;
            }
        }
        if(start == end){
            end --;
            start ++;
        }
        if(end > low){
            sortArray(arr, low, end);
        }
        if(start < high){
            sortArray(arr, start, high);
        }
    }
}
