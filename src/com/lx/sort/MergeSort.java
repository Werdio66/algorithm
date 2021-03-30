package com.lx.sort;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-17 13:28:11
 */
public class MergeSort {

    public static void sort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int mid = left - (left - right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right, new int[right - left + 1]);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int t = 0, r = mid + 1;
        while (left <= mid && r <= right){
            if (arr[left] < arr[r]){
                temp[t++] = arr[left++];
            }else {
                temp[t++] = arr[r++];
            }
        }
        while (left <= mid){
            temp[t++] = arr[left++];
        }
        while (r <= right){
            temp[t++] = arr[r++];
        }

        while (--t >= 0){
            arr[right--] = temp[t];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 4, 8, 6, 2, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
