package com.lx.sort;

import com.lx.ArrayUtil;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-17 11:41:46
 */
public class BullenSort {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]){
                    ArrayUtil.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 4, 8, 6, 2, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
