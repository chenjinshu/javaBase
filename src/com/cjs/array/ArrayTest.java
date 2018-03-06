package com.cjs.array;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;
import java.util.Calendar;
import java.util.Date;

public class ArrayTest {

    public static void  main(String[] args) throws ParseException {
    	BigDecimal expenseNormal = null;
		BigDecimal expenseDestination = null;
		BigDecimal days = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginTime = sd.parse("2017-12-31 09:00:00");
		Date endTime = sd.parse("2018-01-01 07:00:00");
		
        int[] a = new int[]{1,2,3,4,5};
        // int[] a = new int[5]{1,2,3,4,5};    // 错误，在数组声明同时赋值时不能指定数组长度

        String[] b = { "liqing", "jinzhanyi", "chenjinshu"};
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        String ai = "";
        Vector<String> vector = new Vector<>();
        vector.add("345");
        System.out.println(vector.get(0));
    }
}
