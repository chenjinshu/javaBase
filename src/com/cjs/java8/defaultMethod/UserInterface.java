package com.cjs.java8.defaultMethod;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/14
 */
public interface UserInterface {

    void getUserDetail(String userName);

    default void createUser() {
        System.out.println("该平台不支持创建员工创建操作");
    }
}
