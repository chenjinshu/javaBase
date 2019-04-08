package com.cjs.java8.defaultMethod;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/14
 */
public class Test1 implements UserInterface, GoodsInterface {

    @Override
    public void getUserDetail(String userName) {
        System.out.println("获取到用户" + userName + "的信息");
    }

    @Override
    public void createUser() {
        System.out.println("创建自定义员工...");
    }

//    @Override
//    public void createGoods() {
//        System.out.println("创建自定义商品...");
//    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.getUserDetail("cjs");
        test1.createGoods();
        test1.createUser();
    }

}
