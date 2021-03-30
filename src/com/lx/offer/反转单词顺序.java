package com.lx.offer;

/**
 * @author Werdio丶
 * @since 2021-02-01 16:10:42
 */
public class 反转单词顺序 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        while (j >= 0){
            while (i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            sb.append(s, i + 1, j + 1);
            while (i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            sb.append(" ");
            j = i;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.println(reverseWords(s));
    }
}
