package com.cjs.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test {

    public static void main(String[] args) {
    	
    	List<String> list = new ArrayList<>();
    	setList(list);
    	System.out.println(list.get(0));
    	
    }
    
    public static void setList(List<String> list) {
    	list.add("aaa");
    }

}
