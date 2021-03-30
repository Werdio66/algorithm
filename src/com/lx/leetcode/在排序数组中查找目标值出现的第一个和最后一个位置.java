package com.lx.leetcode;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2020-12-01 19:12:42
 */
public class 在排序数组中查找目标值出现的第一个和最后一个位置 {

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        while (left <= right){
            int mid = (left + right) / 2;
            if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                right = mid - 1;
            }else {
                left = right = mid;
                while (nums[left] == target){
                    res[0] = left;
                    if (left == 0){
                        break;
                    }
                    left--;
                }
                while (nums[right] == target){
                    res[1] = right;
                    if (right == nums.length - 1){
                        break;
                    }
                    right++;
                }
                break;
            }
        }
        return res;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange1(arr, target)));
    }
}
