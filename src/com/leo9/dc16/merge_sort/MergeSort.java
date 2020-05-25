package com.leo9.dc16.merge_sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,5,6,4,3,2,1,123};
        System.out.println("Origin Array -> " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted Array -> " + Arrays.toString(arr));
    }

    //整合方法, 在排序递归前先定义好各种传递参数
    public static void mergeSort(int[] arr){
        //定义临时数组
        int[] temp = new int[arr.length];
        //传入参数, 并开始递归排序
        mergeSort(arr, 0, arr.length-1, temp);
    }

    //归并排序拆分方法 最后进行合并
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            //求出中间索引
            int mid = (left + right) / 2;
            //向左递归进行拆分
            mergeSort(arr, left, mid, temp);
            //向右递归进行拆分, 这里注意mid要加一, 要作为新的右边子数组的左边界
            mergeSort(arr, mid + 1, right, temp);
            //将两个有序子数组排序合并, 按照堆栈思想第一次拆分时的最大的索引是最后才进行排序运算的
            mergeArray(arr, left, mid, right, temp);
        }
    }

    //归并排序合并方法
    /**
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边有序序列的初始索引
     * @param temp 中转数组
     * */
    public static void mergeArray(int[] arr, int left, int mid, int right, int[] temp){
        //初始化i, 表示左边有序序列的初始索引
        int i = left;
        //初始化j, 表示右边有序序列的初始索引
        int j = mid + 1;
        //初始化t, 指向temp数组的当前索引
        int t = 0;

        //第一步
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列有一边处理完毕为止
        while(i <= mid && j <= right){
            //若左侧有序数组当前指向元素小于等于右侧有序数组当前指向元素
            //则先将小的元素放入临时数组, 由小到大进行排序
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }
            else{
                temp[t] = arr[j];
                j++;
                t++;
            }
        }


        //第二步
        //把另一边剩余的数据一次全部填充到temp中
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //第三步
        //将temp数组中的数据拷贝到原数组arr中
        //并非每次都是拷贝整个数组的数组, 因为每次拆分的长度是不一样的
        //因此需要按照拆分边界进行划分
        t = 0;
        while(left <= right){
            arr[left] = temp[t];
            left++;
            t++;
        }
    }
}
