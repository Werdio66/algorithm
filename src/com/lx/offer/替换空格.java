package com.lx.offer;

/**
 * @author Werdio丶
 * @since 2021-01-26 14:55:11
 */
public class 替换空格 {

    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                count++;
            }
        }
        char[] res = new char[chars.length + count * 2];
        int i = chars.length - 1;
        int j = res.length - 1;
        while (i >= 0){
            if (chars[i] != ' '){
                res[j--] = chars[i--];
            }else {
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
                i--;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
