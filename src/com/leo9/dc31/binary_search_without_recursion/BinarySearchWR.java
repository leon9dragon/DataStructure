package com.leo9.dc31.binary_search_without_recursion;

public class BinarySearchWR {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int target = 17;
        int res = searchTarget(arr, target);
        if (res != -1) {
            System.out.println("==================");
            System.out.printf("target in array is arr[%d]=%d", res, arr[res]);
        } else {
            System.out.println("==================");
            System.out.println("target is not existed in array!");
        }
    }

    //二分查找的非递归实现

    /**
     * @param arr    待查找的数组
     * @param target 需要查找的目标数
     * @return 返回目标在数组中的下标, 若目标不存在于数组, 返回 -1
     */
    public static int searchTarget(int[] arr, int target) {
        //查找范围的左右两端的下标
        int left = 0;
        int right = arr.length - 1;
        //若左右边界不重合或交错, 则继续查找, 直到出现目标或找不到为止
        while (left <= right) {
            //找到数组中间元素的下标
            int mid = (left + right) / 2;
            //如果数组中间元素与目标相等, 则直接返回下标
            if (arr[mid] == target) {
                return mid;
            }
            //如果数组中间元素大于目标, 则右边界从中间元素的上一位开始, 向左查找
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            //如果数组中间元素小于目标, 则左边界从中间元素的下一位开始, 向右查找
            else {
                left = mid + 1;
            }
        }
        //若最终找不到, 则返回 -1
        return -1;
    }
}
