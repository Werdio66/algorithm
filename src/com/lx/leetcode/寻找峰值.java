package com.lx.leetcode;

/**
 * @author Werdio丶
 * @since 2021-02-26 10:38:32
 */
public class 寻找峰值 {

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l - (l - r) >> 1;
            if (nums[mid] > nums[mid + 1]){
                r = mid;
            }else {
                l = mid;
            }
        }
        return l;
    }

    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if (l == r){
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1]){
            return search(nums, l, mid);
        }else {
            return search(nums, mid + 1, r);
        }
    }
}
