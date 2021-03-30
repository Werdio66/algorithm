package com.lx;

/**
 * @author Werdio丶
 * @since 2020-12-09 17:06:01
 */
public class ArrayUtil {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
