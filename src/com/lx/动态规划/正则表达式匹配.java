package com.lx.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2020-12-17 21:18:04
 */
public class 正则表达式匹配 {

    /**
     *  如果模式串字符是 . ，那么有俩种情况
     *      1、匹配当前字符，
     *          继续匹配下一个字符
     *      2、不匹配
     *  如果当前字符后一个是 *，那么有 2 种情况
     *      1、如果当前字符匹配
     *          可以继续匹配多个字符或者 0 个字符
     *      2、当前字符不匹配
     *          只能匹配 0 个字符
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        return dp1(s, 0, p, 0);
    }
    private static boolean dp(String s, int i, String p, int j) {
        if (j == p.length()){
            return i == s.length();
        }
        // 检查 p 剩余字符串是否为 x*y*z* 即可以成为空字符串的情况
        if (i == s.length()){
            // 不是成对出现，不可能为空串
            if ((p.length() - j) % 2 == 1){
                return false;
            }

            for (; j + 1 < p.length(); j += 2) {
                if (p.charAt(j + 1) != '*'){
                    return false;
                }
            }
            return true;
        }

        // 当前字符匹配或者 p[j] == .
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 判断后一个字符是否为 *
            if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                // 匹配 0 次或者多次
                return dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            }else {
                // 后一个字符不是 *，正常匹配 .，直接后移俩个字符串即可
                return  dp(s, i + 1, p, j + 1);
            }
        }else {
            // 当前字符不匹配，只能匹配 0 个
            //
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // 匹配 0 次
                return  dp(s, i, p, j + 2);
            }else {
                return false;
            }
        }

    }
    static Map<String, Boolean> memo = new HashMap<>();
    private static boolean dp1(String s, int i, String p, int j) {
        if (j == p.length()){
            return i == s.length();
        }
        // 检查 p 剩余字符串是否为 x*y*z* 即可以成为空字符串的情况
        if (i == s.length()){
            // 不是成对出现，不可能为空串
            if ((p.length() - j) % 2 == 1){
                return false;
            }

            for (; j + 1 < p.length();  j += 2) {
                if (p.charAt(j + 1) != '*'){
                    return false;
                }
            }
            return true;
        }
        String key = i + "," + j;
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        boolean res;
        // 当前字符匹配或者 p[j] == .
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 判断后一个字符是否为 *
            if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                // 匹配 0 次或者多次
                res = dp1(s, i, p, j + 2) || dp1(s, i + 1, p, j);
            }else {
                // 后一个字符不是 *，正常匹配 .，直接后移俩个字符串即可
                res = dp1(s, i + 1, p, j + 1);
            }
        }else {
            // 当前字符不匹配，只能匹配 0 个
            //
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // 匹配 0 次
                res =   dp1(s, i, p, j + 2);
            }else {
                res =  false;
            }
        }
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }
}
