package com.lx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2021-03-12 10:37:02
 */
public class 数组中频率最大的数 {
    
    private static void f(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                continue;
            }
            map.put(num, 1);
        }
        int count = 0;
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            if (value > count){
                count = value;
                num = key;
            }
        }
        System.out.println(num + "---" + count);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 43, 2, 1, 2, 3, 4, 54, 6, 6, 7, 5, 4, 3, 3, 3, 3, 3, 3};
        f(arr);
    }
}
