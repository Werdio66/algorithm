package com.lx.offer;

import com.lx.ArrayUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Werdio丶
 * @since 2021-01-30 19:07:36
 */
public class 最小的k个数 {

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        int[] res = new int[k];
        for (int i = 0; i < arr.length; i++) {

            heap.offer(arr[i]);

            if (heap.size() > k){
                heap.poll();
            }

        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    /**
     *  使用快速排序思想找到第 k 小的元素的位置，那么最小的 l 个数就是 index 左边的数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        int[] res = new int[k];
        int target = k - 1;
        int left = 0, right = arr.length - 1, count = 0;
//        target = arr.length - target;
        while (left <= right){
            int index = partition(arr, left, right);
            if (index > target){
                right = index - 1;
            }else if (index < target){
                left = index + 1;
            }else {
                // 找到 k 的位置，k 左边都是比 k 小的数
                while (--k >= 0){
                    res[k] = arr[k];
                }
                return res;
            }
        }
        return res;
    }

    public static int quickGet(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
//        target = arr.length - target;
        target--;
        while (left <= right){
            int index = partition(arr, left, right);
            if (index == target){
                return arr[target];
            }else if (index < target){
                left = index + 1;
            }else {
                right = index - 1;
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int left, int right) {
        int partion = arr[right];
        while (left < right){
            while (left < right && arr[left] <= partion){
                left++;
            }
            if (left < right){
                ArrayUtil.swap(arr, left, right);
                right--;
            }
            while (left < right && arr[right] > partion){
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
        int[] arr = {1, 5, 3, 2, 6, 2, 4, 4};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 3)));
        System.out.println(Arrays.toString(getLeastNumbers1(arr, 3)));
        System.out.println(quickGet(arr, 1));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
