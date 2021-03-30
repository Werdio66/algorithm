package com.lx.test;

/**
 * @author Werdio丶
 * @since 2021-02-27 16:11:07
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        stringThreadLocal.set("hello word");
        integerThreadLocal.set(2021);
        String s = stringThreadLocal.get();

    }
}
