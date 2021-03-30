package com.lx.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Werdio丶
 * @since 2020-11-13 19:51:27
 */
public class lalalala {

    public static void main(String[] args) {
        jisuan(2020, 11, 9, 27, 10);
    }

    /**
     * @param year   年
     * @param mouth  月
     * @param day    日
     * @param amount 多少天之后
     * @param count  计算多少次
     */
    private static void jisuan(int year, int mouth, int day, int amount, int count) {
        Date old = new Date(year - 1900, mouth - 1, day);
        while (count-- > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(old);
            calendar.add(Calendar.DATE, amount);
            Date date = calendar.getTime();
            DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);
            String string = format.format(date);
            System.out.println(string);
            old = date;
        }
    }
}
