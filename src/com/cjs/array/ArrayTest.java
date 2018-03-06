package com.cjs.array;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ArrayTest {

<<<<<<< HEAD
    public static void  main(String[] args) throws ParseException {
    	BigDecimal expenseNormal = null;
		BigDecimal expenseDestination = null;
		BigDecimal days = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginTime = sd.parse("2017-12-31 09:00:00");
		Date endTime = sd.parse("2018-01-01 07:00:00");
		
		BigDecimal a = new BigDecimal(2);
		BigDecimal b = new BigDecimal(2.0);
		System.out.println(a.compareTo(b));
		
=======
    public static void  main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        // int[] a = new int[5]{1,2,3,4,5};    // 错误，在数组声明同时赋值时不能指定数组长度

        String[] b = { "liqing", "jinzhanyi", "chenjinshu"};
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        String ai = "";
        
>>>>>>> a13fe4b10876783a78d9f1f5a64df6d05dfd36ca
    }
}
