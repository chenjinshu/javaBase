package com.cjs.designModeTest.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/03
 */
public class ProxyHandler implements InvocationHandler {

    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("========= before request =========");
        Object result = method.invoke(subject, args);
        System.out.println("========= after request =========");
        return result;
    }
}
