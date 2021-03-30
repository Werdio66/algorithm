package com.lx.leetcode;

import com.lx.ArrayUtil;
import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2020-12-09 16:59:17
 */
public class 洗牌算法 {

    public static void shuffle(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int rand = i + (int) (Math.random() * (n - i));
            ArrayUtil.swap(arr, i, rand);
        }
    }

    public static void verification(int[] arr, int n){
        int[] count = new int[arr.length];
        for (int i = 0; i < n; i++) {
            shuffle(arr);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 1){
                    count[j]++;
                }
            }
        }

        System.out.println(Arrays.toString(count));
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 0};
        int n = 1000_0000;
        verification(arr, n);
    }
}
