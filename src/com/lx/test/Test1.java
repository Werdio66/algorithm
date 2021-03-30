package com.lx.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Werdio丶
 * @since 2021-03-04 19:10:32
 */
public class Test1 {
    private static Set<Character> set = new HashSet<>();
    public static void main(String[] args) {
        set.add('*');
        set.add('-');
        set.add('+');
    }
    public int f(String s){
        int res = 0;
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(1));
        int i = 2;
        while (!stack.isEmpty()){
            char c = s.charAt(i);
            if (set.contains(c)){
                stack.push(c);
            }else {
                Character operator = stack.pop();

            }
        }
        return res;
    }

    static int maxAmount(int[] packets, int n) {
        int m = packets.length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        int[] sub = new int[m + 1];
        for (int i = 0; i < m; i++) {
            sub[i + 1] = sub[i] + packets[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.max(f[i][j], Math.min(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
