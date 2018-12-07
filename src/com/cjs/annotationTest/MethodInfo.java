package com.cjs.annotationTest;

import java.lang.annotation.*;

/**
 * @author chen.jinshu
 * 2018/08/01
 */
@Documented
@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "chen.jinshu";
    String date();
    int revision() default 1;
    String comments();
}
