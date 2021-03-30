package com.lx.sort;

import com.lx.ArrayUtil;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-17 13:11:45
 */
public class QuickSort {

    public static void sort(int[] arr, int left, int right){
        if (left > right){
            return;
        }
        int index = partition(arr, left, right);
        sort(arr, left, index - 1);
        sort(arr, index + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int point = arr[right];
        while (left < right){
            while (left < right && arr[left] < point){
                left++;
            }
            if (left < right){
                ArrayUtil.swap(arr, left, right);
                right--;
            }
            while (left < right && arr[right] >= point){
                right--;
            }
            if (left < right){
                ArrayUtil.swap(arr, left, right);
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 4, 8, 6, 2, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
