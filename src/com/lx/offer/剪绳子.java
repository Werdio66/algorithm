package com.lx.offer;

/**
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最
 * 大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得
 * 到的最大乘积是18。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Werdio丶
 * @since 2021-01-25 14:46:03
 */
public class 剪绳子 {

    public static int cuttingRope(int n) {
        if (n < 4){
            return n - 1;
        }
        return back(n);
    }

    private static int back(int n) {
        if (n <= 4){
            return n;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, i * back(n - i));
        }
        return res;
    }

    public static int cuttingRope1(int n) {
        if (n < 4){
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= 4; i++) {
            dp[i] = i;
        }
        for (int i = 5; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope1(10));
    }
}
