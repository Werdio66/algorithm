package com.lx.leetcode;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-16 12:08:05
 */
public class 调整数组使奇数在偶数前面且相对位置不变 {

    public static void reOrderArray(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int target = arr[i];
            if ((target & 1) == 1){
                int j;
                for (j = i - 1; j >= 0; j--) {
                    if ((arr[j] & 1) == 0){
                        arr[j + 1] = arr[j];
                    }else {
                        break;
                    }
                }
                arr[j + 1] = target;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
