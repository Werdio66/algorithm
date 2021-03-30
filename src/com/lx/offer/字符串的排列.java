package com.lx.offer;

import java.util.*;

/**
 * @author Werdio丶
 * @since 2021-02-06 09:32:17
 */
public class 字符串的排列 {

    static List<String> list = new ArrayList<>();
    static char[] c;
    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    private static void dfs(int i) {
        if(i == c.length - 1){
            list.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int j = i; j < c.length; j++) {
            if (set.contains(c[j])){
                continue;
            }
            set.add(c[j]);
            swap(i, j);
            dfs(i + 1);
            swap(i, j);
        }
    }

    private static void swap(int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(permutation(s)));
    }
}
