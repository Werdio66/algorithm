package com.lx.offer;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *  1、hash
 *  2、因为数字是从 0 - n，所以对数组排序之后，下标和值相等就是没有重复
 *
 * @author Werdio丶
 * @since 2021-01-25 15:02:17
 */
public class 找出数组中的重复数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int result = -1;

        for (int num : nums) {
            if (!set.add(num)){
                result = num;
            }
        }

        return result;
    }

    public static int findRepeatNumber1(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(arr));
    }
}
