package com.lx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Werdio丶
 * @since 2021-02-19 10:21:10
 */
public class 数组中比左边元素大比右边元素小的数 {


    public static int[] middleNums(int[] arr){
        List<Integer> list = new ArrayList<>();
        int maxValue = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > maxValue){
                maxValue = arr[i];
                list.add(i);
            }
        }
        int minValue = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= minValue && list.contains(i)){
                list.remove(new Integer(i));
            }else if (arr[i] < minValue){
                minValue = arr[i];
            }
        }
        return list.parallelStream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5};
        System.out.println(Arrays.toString(middleNums(arr)));

    }
}
