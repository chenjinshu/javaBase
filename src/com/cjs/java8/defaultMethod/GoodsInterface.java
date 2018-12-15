package com.cjs.java8.defaultMethod;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/14
 */
public interface GoodsInterface {

    default void createGoods() {
        System.out.println("创建默认商品...");
    }
}
