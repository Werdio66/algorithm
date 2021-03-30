package com.lx.offer;

import java.util.Arrays;

/**
 * @author Werdio丶
 * @since 2021-01-26 12:38:21
 */
public class 打印从1到n最大n位数 {

    int n, count;
    char[] nums;
    public int[] printNumbers(int n) {
        this.n = n;
        nums = new char[n];

        int[] res = new int[(int)Math.pow(10, n)];

        dfs(res, 0);

        return res;
    }

    private void dfs(int[] res, int index) {
        if (index == this.n){
            String str = String.valueOf(nums);
            res[count++] = Integer.parseInt(str);
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            nums[index] = i;
            dfs(res, index + 1);
        }
    }

    public static void main(String[] args) {
        打印从1到n最大n位数 d = new 打印从1到n最大n位数();
        System.out.println(Arrays.toString(d.printNumbers(10)));
    }
}
