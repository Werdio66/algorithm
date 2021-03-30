package com.lx.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2021-03-25 20:29:10
 */
public class Main {

    public String compressString (String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else {
                map.put(key, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1){
                flag = true;
            }
            sb.append(key).append(value);
        }
        if (!flag){
            return str;
        }
        return sb.length() > str.length() ? str : sb.toString();
    }

    public static int maxChunksToSorted (int[] arr) {
        int res = 1;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            maxVal = Math.max(arr[i], maxVal);
            minVal = Math.min(minVal, arr[i]);
            if (maxVal > arr[i + 1]){
                continue;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 6, 1};
        System.out.println(maxChunksToSorted(arr));
    }
}
