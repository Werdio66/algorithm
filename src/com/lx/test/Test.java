package com.lx.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 保融笔试
 *
 * @author Werdio丶
 * @since 2021-02-27 16:58:06
 */
public class Test {

    static Object lock = new Object();
    public static String changeFormatNumber (String number) {
        int num;
        try{
            num = Integer.parseInt(number);
        }catch (NumberFormatException e){
            return "INPUTERROR";
        }
        if (Math.abs(num) >= Math.pow(2, 15)){
            return "NODATA";
        }
        StringBuilder sb = new StringBuilder();
        String binaryString = Integer.toBinaryString(num);
        for (int i = 0; i < 16 - binaryString.length(); i++) {
            sb.append("0");
        }
        if (binaryString.length() > 16){
            binaryString = binaryString.substring(16);
        }
        sb.append(binaryString).append(",");
        String hexString = Integer.toHexString(num);
        for (int i = 0; i < 4 - hexString.length(); i++) {
            sb.append("0");
        }
        if (hexString.length() > 4){
            hexString = hexString.substring(4);
        }
        sb.append(hexString.toUpperCase());
        return sb.toString();
    }

    public static void main(String[] args) {
        int pow = (int)Math.pow(2, 16);
//        System.out.println(changeFormatNumber(Integer.toString(pow)));
        System.out.println(changeFormatNumber("-2"));
        Object o = (Object) new Son();
        Parent p = (Parent) o;
        System.out.println(p.num);

        synchronized (Test.class){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Parent{
        int num = 2;
    }

    static class Son extends Parent{

    }
 
}
