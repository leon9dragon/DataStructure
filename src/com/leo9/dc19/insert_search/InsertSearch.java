package com.leo9.dc19.insert_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,1,2,3,3,3,4,5,6,9,9,9,9};
        int key = 3;
        System.out.printf("the array is " + Arrays.toString(arr) + "\n" + "the key value is [%d]\n", key);
        searchKey(arr, key, 0, arr.length-1);
    }

    public static void searchKey(int[] arr, int key, int left, int right){
        //索引越界时输出并跳出递归
        if(left > right){
            System.out.println("not found");
            return;
        }

        //获取中间索引
        int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);

        if(arr[mid] == key){
            //找出所有相同元素值, 并将它们的索引放入集合中
            ArrayList<Integer> keyIndex = new ArrayList<Integer>();

            //先将第一次找到的索引存入
            keyIndex.add(mid);

            //目标向左查找
            for (int i = mid - 1; i >= 0 ; i--) {
                if(arr[i] == key){
                    keyIndex.add(i);
                }
            }

            //目标向右查找
            for (int i = mid + 1; i < arr.length ; i++) {
                if(arr[i] == key){
                    keyIndex.add(i);
                }
            }

            //先给索引集合排序, 然后再输出
            Collections.sort(keyIndex);
            System.out.printf("found the key in array, the index is " + keyIndex.toString());
        }
        else if(key > arr[mid]){
            //左边界变为mid+1, 保留右边界不变, 因为arr[mid]没必要再比较所以右移一位, 同时右移一位能保证最终可以获取到右边界
            searchKey(arr, key, mid+1, right);
        }
        else if(key < arr[mid]){
            //右边界变为mid-1, 保留左边界不变, 理由同上
            searchKey(arr, key, left, mid-1);
        }
    }
}