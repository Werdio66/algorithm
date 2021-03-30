package com.lx.leetcode;

/**
 * @author Werdio丶
 * @since 2021-03-12 10:32:26
 */
public class 寻找俩个正序数组的中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = 0;
        int n = 0;
        int len = nums1.length + nums2.length;
        int left = -1;
        int right = -1;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (m < nums1.length && (n >= nums2.length || nums1[m] < nums2[n])){
                right = nums1[m++];
            }else {
                right = nums2[n++];
            }
        }
        if ((len & 1) == 0){
            return (left + right) / 2.0;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
