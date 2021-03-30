package com.lx.sort;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-17 11:17:35
 */
public class InstertSort {

    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;
            while (j >= 0 && target < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 4, 8, 6, 2, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
