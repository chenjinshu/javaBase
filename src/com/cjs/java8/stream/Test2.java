package com.cjs.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        Student s1 = new Student("cjs", "hongya", 25);
        Student s2 = new Student("hqt", "hongya", 23);
        Student s3 = new Student("lq", "yaan", 26);
        Student s4 = new Student("sq", "hongya", 24);
        List<Student> students = new ArrayList(){{
            add(s1);
            add(s2);
            add(s3);
            add(s4);
        }};

        List<String> names = students
                .parallelStream()
                // 过滤掉school不是"hongya"的student
                .filter(student -> student.getSchool().equals("hongya"))
                // 将过滤后的结果按照age降序排列
                .sorted(Comparator.comparing(Student::getAge).reversed())
                // 只取name
                .map(Student::getName)
                // 转换为list
                .collect(Collectors.toList());
        System.out.println(names);

        int ageSum = students
                .parallelStream()
                .filter(student -> student.getSchool().equals("hongya"))
                .mapToInt(Student::getAge)
                .sum();
        // 72 = 25 + 24 + 23
        System.out.println(ageSum);
    }
}
