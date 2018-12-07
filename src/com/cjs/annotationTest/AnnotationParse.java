package com.cjs.annotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 利用反射技术来解析注解
 * @author chen.jinshu
 * 2018/08/01
 */
public class AnnotationParse {

    public static void main(String[] args) {
        try {
            for(Method method : AnnotationParse.class.getClassLoader().
                    loadClass("com.cjs.annotationTest.AnnoTest1").getDeclaredMethods()) {
                // 该方法具有MethodInfo这个注解,前提是该注解的retention是runtime，否则反射是获取不到该注解的
                // 比如在下面的打印结果中就不会打印出SuppressWarnings这个注解信息
                if(method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        for(Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method " + method + " : " + anno);
                        }
                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                        if(methodInfo.revision() == 2) {
                            System.out.println("Method with revision no 2 = " + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
