package com.cjs.java8.stream;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/14
 */
public class Test1 {

    public static void main(String[] args) {
        // 分组(获取某个pojo集合的某个字段的合集)
        Student student1 = new Student("cjs", 24);
        Student student2 = new Student("hqt", 23);
        Student student3 = new Student("sq", 24);
        List<Student> studentList = Arrays.asList(student1, student2, student3);
//        List<String> nameList = studentList.stream().map(Student::getName).distinct().collect(Collectors.toList());
//        List<Integer> ageList = studentList.stream().map(Student::getAge).distinct().collect(Collectors.toList());
//        System.out.println(nameList);
//        System.out.println(ageList);


        List<Integer> result = getPropertyValueList(studentList, "name");
        System.out.println(result);
        //
    }

    private static <T, R> List<R> getPropertyValueList(List<T> sourceList, String propertyName) {
        return sourceList.stream().map(t -> {
            R value = null;
            String methodName = "get" + propertyName.replaceFirst(propertyName.substring(0, 1), propertyName.substring(0, 1).toUpperCase());
            try {
                Method method = t.getClass().getDeclaredMethod(methodName);
                value = (R) method.invoke(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return value;
        }).distinct().collect(Collectors.toList());
    }
}
