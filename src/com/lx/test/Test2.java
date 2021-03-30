package com.lx.test;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author Werdio丶
 * @since 2021-03-06 15:49:35
 */
public class Test2 {

    public int MaxMilk (int[] grass, int[] milk) {
        // write code here
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < grass.length; i++){
            if(map.containsKey(grass[i])){
                map.put(grass[i], map.get(grass[i]) + milk[i]);
            }else {
                map.put(grass[i], milk[i]);
            }

        }
        Iterator<Integer> iterator = map.values().iterator();
        int prev = -1;
        int sum = 0;
        while (iterator.hasNext()){
            Integer cur = iterator.next();
            if (prev != -1){

            }
            prev = cur;
        }
       return  res;
    }

    public int MaxMilk1 (int[] grass, int[] milk) {
        int[][] dp = new int[grass.length + 1][milk.length + 1];

        for (int i = 1; i <= grass.length; i++) {
            for (int j = i; j <= milk.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + milk[j], 1);
            }
        }
        return 1;
    }
}
