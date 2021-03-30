package com.lx.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2021-01-28 18:47:56
 */
public class 第一个出现一次的字符 {

    public static char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, !map.containsKey(c));
        }
        char res = ' ';
        for (Map.Entry<Character, Boolean> entry : map.entrySet()){
            if (entry.getValue()){
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
