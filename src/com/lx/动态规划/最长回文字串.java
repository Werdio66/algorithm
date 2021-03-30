package com.lx.动态规划;

/**
 * @author Werdio丶
 * @since 2020-12-06 15:43:08
 */
public class 最长回文字串 {

    public static String longestPalindrome(String s) {
        int len, l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer len1 = palindrome(s, i, i);
            Integer len2 = palindrome(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > r - l){
                l = i - (len - 1) / 2;
                r = i + len / 2;
            }
        }
        return s.substring(l, r + 1);
    }

    public static Integer palindrome(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return r - l - 1;
    }


    public static String longestPalindrome1(String s) {
        String str = getStr(s);
        int r = 0, l = 0;
        for (int i = 0; i < str.length(); i++) {
           int len = palindrome(str, i, i);
           if (len > r - l){
               l = i - len / 2;
               r = i + len / 2;
           }
        }
        return str.substring(l, r).replaceAll("#", "");
    }

    private static String getStr(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(getStr(s));
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome1(s));
    }
}
