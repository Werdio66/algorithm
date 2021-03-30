package com.lx.test;

/**
 * @author Werdio丶
 * @since 2021-03-17 11:59:21
 */
public class Main {
    public static void main(String[] args) {
        int s = 0;
        double k = 0.2;
        while (s <= 2020){
            if (k >= 0.2 && k <= 0.5){
                k = k * 2;
                s++;
            }else {
                k = k * 2 - 1;
                s++;
            }
        }
        System.out.println(k);
    }
}
