package com.cjs.designModeTest.proxyMode;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/03
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("======= request =======");
    }
}
