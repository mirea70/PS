package com.exercise.ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSort {
    public static void comparatorSort(List<Integer> list) {

        // 오름차순
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        // 내림차순
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        // 여러 기준이 필요할 때,
        Student student1 = new Student(15, 180);
        Student student2 = new Student(18, 160);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 1번째 정렬기준
                if(o1.age != o2.age) {
                    return o2.age - o1.age;
                }
                // 2번째 정렬기준
                else
                    return o2.height - o1.height;
            }
        });
    }
}

class Student {
    int age;
    int height;

    public Student(int age, int height) {
        this.age = age;
        this.height = height;
    }
}
