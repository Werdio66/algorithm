package com.lx.offer;

/**
 * @author Werdio丶
 * @since 2021-02-01 09:36:10
 */
public class 在排序数组中查找数字 {

    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    public int helper(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] <= target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
