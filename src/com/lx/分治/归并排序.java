package com.lx.分治;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2020-12-01 19:52:06
 */
public class 归并排序 {

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= right){
            if (arr[l] < arr[r]){
                temp[t++] = arr[l++];
            }else {
                temp[t++] = arr[r++];
            }

        }
        while (l <= mid){
            temp[t++] = arr[l++];
        }
        while (r <= right){
            temp[t++] = arr[r++];
        }

        t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 8, 6};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
}
