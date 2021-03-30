package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2020-12-03 20:54:31
 */
public class 接雨水 {

    /**
     *  在每一个位置计算其左边和右边的最大值，然后减去当前的高度就是这个位置接的雨水量
     *  时间复杂度 O(n ^ 2) 空间复杂度 O(1)
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lmax = 0, rmax = 0;
            for (int j = i; j >= 0; j--) {
                lmax = Math.max(lmax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rmax = Math.max(rmax, height[j]);
            }
            ans += Math.min(lmax, rmax) - height[i];
        }
        return ans;
    }

    public static int trap1(int[] height) {
        int ans = 0;
        int length = height.length;
        int[] lmax = new int[length];
        int[] rmax = new int[length];
        lmax[0] = height[0];
        rmax[length - 1] = height[length - 1];
        // 从左到右找最大的
        for (int i = 1; i < length; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        // 从右往左找最大的
        for (int i = length - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        for (int i = 1; i < length - 2; i++) {
            ans += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return ans;
    }

    public static int trap2(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1;
        int lmax = height[0];
        int rmax = height[length - 1];
        int ans = 0;
        while (left <= right){
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            if (lmax < rmax){
                ans += lmax - height[left];
                left++;
            }else {
                ans += rmax - height[right];
                right--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap1(height));
        System.out.println(trap2(height));
    }
}
