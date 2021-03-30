package com.lx.sort;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-17 11:22:22
 */
public class ShellSort {

    public static void sort(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int target = arr[i];
                int j = i - gap;
                while (j >= 0 && target < arr[j]){
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = target;
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
