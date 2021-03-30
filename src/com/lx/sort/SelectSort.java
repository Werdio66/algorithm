package com.lx.sort;

import com.lx.ArrayUtil;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-17 11:10:50
 */
public class SelectSort {

    public static void sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (value > arr[j]){
                    value = arr[j];
                    index = j;
                }
            }
            ArrayUtil.swap(arr, i, index);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 4, 8, 6, 2, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
