package com.cjs.designModeTest.proxyMode;

import java.lang.reflect.Proxy;

/**
 * 动态代理模式
 * @author chen.jinshu (青禾)
 * 2018/12/03
 */
public class DynamicProxyModeTest {

    public static void main(String[] args) {
        // 创建实际被调用的对象(被代理对象)
        RealSubject realSubject = new RealSubject();
        // 创建代理处理器对象，用于处理被代理对象中的方法
        ProxyHandler handler = new ProxyHandler(realSubject);
        // 动态创建代理对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        // 调用代理对象的方法
        proxySubject.request();
    }

    /**
     * 参考资料：https://www.jianshu.com/p/6f6bb2f0ece9
     * */
}
