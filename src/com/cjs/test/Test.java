package com.cjs.test;

public class Test {

    public static void main(String[] args) {
        String[] arr = {"cjs", "lq", "llp"};
        String[] arrCopy = new String[3];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        for(String s : arrCopy) {
        	System.out.println(s);
        }
    }

}
