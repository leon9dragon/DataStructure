package com.leo9.dc20.fibonacci_search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int MAXSIZE = 20;
    public static void main(String[] args) {
        int[] arr = {0,16,24,35,47,59,62,73,88,99};
        int key = 777;
        int res = fibSearch(arr, key);
        System.out.printf("the array is " + Arrays.toString(arr) + "\nthe key is [%d]", key);
        if(res != -1){
            System.out.printf("\nfound the key in arr[%d] = %d", res, arr[res]);
        }
        else {
            System.out.println("\nnot found");
        }
    }

    //因为后面定位mid要用到斐波那契数列, 因此需要先获取到一个斐波那契数列
    //非递归方法获取斐波那契数列
    public static int[] fib(){
        int[] f = new int[MAXSIZE];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < MAXSIZE; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    //编写斐波那契查找算法
    /**
     * @param a 目标数组
     * @param key 目标数值
     * @return 返回对应的下标, 找不到则为-1
     * */
    public static int fibSearch(int[] a, int key){
        int low = 0;
        int high = a.length - 1;
        //定义k表示斐波那契分割数值的下标
        int k = 0;
        //定义mid存放mid值
        int mid = 0;
        //获取斐波那契数列
        int f[] = fib();
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1){
            k++;
        }
        //因为f[k]的值可能大于数组长度, 因此需要构造新的数组并指向temp数组
        //如下新数组多出来的部分会用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //将多出来的部分用原数组最后一位填充
        for (int i = high + 1; i < temp.length; i++){
            temp[i] = a[high];
        }
        //使用while来循环处理, 找到目标key
        while (low <= high){
            mid = low + f[k - 1] - 1;
            //向数组左边查找
            if(key < temp[mid]){
                //数组末端向左收缩
                high = mid - 1;
                //继续拆分数组,
                //数组由两部分组成 f[k] - 1 = f[k-1]-1 + f[k-2]-1 + 1
                //斐波那契查找的核心就是在mid前面的长度为f[k-1]-1,在mid的后面的长度为f[k-2]-1
                //左边部分是 f[k-1]-1, 中间的mid则为最后的+1
                k--;
            }
            //向数组右边查找
            else if(key > temp[mid]){
                //数组首端向右收缩
                low = mid + 1;
                //继续拆分数组
                //数组右边部分是f[k-2]-1
                k -= 2;
            }
            else{
                //找到key, 确定返回下标
                if(mid <= high){
                    return mid;
                }
                else {
                    return high;
                }
            }
        }
        //找不到key, 返回-1
        return -1;
    }
}
