package com.lx.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Werdio丶
 * @since 2021-02-05 10:01:25
 */
public class 把数组排成最小的数 {
    public static String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i] + "");
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for (String s : list) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 21, 5};
        System.out.println(minNumber(arr));
    }
}
