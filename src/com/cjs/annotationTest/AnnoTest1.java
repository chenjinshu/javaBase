package com.cjs.annotationTest;

/**
 * @author chen.jinshu
 * 2018/08/01
 */
public class AnnoTest1 {

    @SuppressWarnings({ "unchecked", "deprecation"})
    @Deprecated
    @MethodInfo(author = "cjs", date = "2018-08-01", revision = 2, comments = "测试1")
    public void test() {

    }
}
