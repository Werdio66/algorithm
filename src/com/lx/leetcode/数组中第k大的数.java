package com.lx.leetcode;

import java.util.PriorityQueue;

/**
 * @author Werdio丶
 * @since 2020-12-09 10:00:35
 */
public class 数组中第k大的数 {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() != k){
                queue.offer(num);
                continue;
            }
            if (num > queue.peek()){
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }

    public static int findKthLargest1(int[] nums, int k) {
        int target = nums.length - k;
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int index = partition(nums, l, r);
            if (index == target){
                 return nums[index];
            }else if (index > target){
                r = index - 1;
            }else {
                l = index + 1;
            }
        }
        return -1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        while (l < r){
            while (l < r && nums[l] < pivot){
                l++;
            }
            if (l < r){
                swap(nums, l, r);
                r--;
            }

            while (l < r && nums[r] > pivot){
                r--;
            }
            if (l < r){
                swap(nums, l, r);
                l++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4, 11, 7, 9, 8};
        System.out.println(findKthLargest(arr, 2));
        System.out.println(findKthLargest1(arr, 2));
    }
}
