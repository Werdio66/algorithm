package com.lx.leetcode;

/**
 *
 * @author Werdio
 * @since 2021-02-04 10:28:08
 */
public class Test {

    private String str = new String("111");

    public static void test(String str){
        str = "ddd";
    }
    public static int get() {
        int a = 1;
        try {
            a = 1 / 0;
//
            return a;
        } catch (Exception e) {

            return a;
        } finally {
            a = 2;
//            return a;
        }


    }

    public static void main(String[] args) {
        System.out.println(get());
        System.out.println(13 & 17);
        System.out.println('2' + 1);
        int a = (int) 'c';
        System.out.println(new Test().str);
        test("222");
    }
}
