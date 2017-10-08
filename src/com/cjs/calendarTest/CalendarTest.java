package com.cjs.calendarTest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int days = calendar.get(Calendar.DAY_OF_YEAR);            // 获取当年已经过去的天数
        System.out.println(days);                                 // 212
        
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.add(Calendar.DATE, 1);                         // 日期加一天
        System.out.println(calendar1.getTime());
        
	}

}
