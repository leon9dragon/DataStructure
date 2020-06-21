package com.leo9.dc25.heap_sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 25, 50, 30, 40, 35, 45};
        System.out.println("=====beforeSort=====\n"+Arrays.toString(arr));
        heapSort(arr);
    }

    //编写一个堆排序方法
    public static void heapSort(int[] arr) {
        System.out.println("=====midSort=====");
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //adjustHeap(arr, 0, arr.length);
        //先将堆顶元素与末尾元素进行交换, 使末尾元素最大.
        //再对堆进行调整, 将堆顶元素与末尾元素交换, 得到第二大元素.
        //如此反复进行交换, 重建, 交换, 最后得出有序序列.
        System.out.println(Arrays.toString(arr));
        System.out.println("=====heapSort=====");

        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //将数组的前length-1位再进行排序
            adjustHeap(arr, 0, j);
        }

        //输出排序后的数组
        System.out.println(Arrays.toString(arr));
    }

    //将数组(二叉树)调整成一个大顶堆

    /**
     * @param arr    待调整数组
     * @param i      非叶子结点在数组中索引
     * @param length 需要调整的元素个数
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值, 保存在临时变量
        int temp = arr[i];
        //开始调整, k一开始指向的是i的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //如果左子结点的值小于右子结点的值
                //k就指向右子结点
                k++;
            }
            if (arr[k] > temp) {
                //如果k所指向的子结点的值大于父结点
                //将较大的值向上移动, 同时改变i的指向
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //当for循环结束后, 已经把以i为父结点的树的最大值, 放在了最顶上
        //将temp的值放到调整后的位置
        arr[i] = temp;
    }
}
