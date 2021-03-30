package com.lx.sort;

import com.lx.ArrayUtil;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-02-17 18:02:26
 */
public class HeapSort {

    public static void sort(int[] arr){

        int index = (arr.length >> 1) - 1;
        // 堆化
        for (int i = index; i >= 0; i--) {
            heapify2(arr, i, arr.length - 1);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            ArrayUtil.swap(arr, i, 0);
            heapify2(arr, 0, i - 1);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int l = 2 * i + 1;
        int r = l + 1;
        int maxIndex = l;
        if (l > len){
            return;
        }
        if (r <= len && arr[r] > arr[l]){
            maxIndex = r;
        }
        if (arr[maxIndex] > arr[i]){
            ArrayUtil.swap(arr, maxIndex, i);
            heapify(arr, maxIndex, len);
        }
    }

    /**
     *  大顶堆
     * @param arr
     * @param i
     * @param len
     */
    private static void heapify1(int[] arr, int i, int len) {
        int index = 2 * i + 1;
        if (index > len){
            return;
        }
        if (index + 1 <= len && arr[index + 1] > arr[index]){
            index++;
        }
        if (arr[index] > arr[i]){
            ArrayUtil.swap(arr, index, i);
            heapify1(arr, index, len);
        }
    }

    /**
     *  小顶堆
     * @param arr
     * @param i
     * @param len
     */
    private static void heapify2(int[] arr, int i, int len) {
        int index = 2 * i + 1;
        if (index > len){
            return;
        }
        if (index + 1 <= len && arr[index + 1] < arr[index]){
            index++;
        }
        if (arr[index] < arr[i]){
            ArrayUtil.swap(arr, index, i);
            heapify2(arr, index, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 4, 8, 6, 2, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
