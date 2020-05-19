package com.leo9.dc15.quick_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {11, 2, 6, 8, 47, 12, 96, 34, 207};
        System.out.println("=========select the mid ele as key===========");
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
            //当开始结束指针相等的时候跳出循环
            if(end == start){
                break;
            }
            //若开始结束指针没有相等, 就将开始结束指针指向的元素位置互换
            else {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        //当结束指针还没指到数组首位时就继续进行分割数组递归排序
        //开始指针要下移一位, 结束指针则要上移一位, 然后判断是否越界, 再进行递归
        if(end > low){
            sortArray(arr, low, end-1);
        }
        //当开始指针还没指到数组末位时就继续进行分割数组递归排序
        if(start < high){
            sortArray(arr, start+1, high);
        }
    }
}
