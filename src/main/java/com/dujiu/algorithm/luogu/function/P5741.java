package com.dujiu.algorithm.luogu.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P5741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int chinese = sc.nextInt();
            int math = sc.nextInt();
            int english = sc.nextInt();
            students[i] = new Student(name, chinese, math, english);
        }

        List<String[]> pairs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Student a = students[i];
                Student b = students[j];
                if (Math.abs(a.chinese - b.chinese) <= 5
                        && Math.abs(a.math - b.math) <= 5
                        && Math.abs(a.english - b.english) <= 5
                        && Math.abs(a.total - b.total) <= 10) {
                    pairs.add(new String[]{a.name, b.name});
                }
            }
        }

        pairs.sort((p1, p2) -> {
            int cmp = p1[0].compareTo(p2[0]);
            if (cmp != 0) {
                return cmp;
            }
            return p1[1].compareTo(p2[1]);
        });

        for (String[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}

class Student {
    String name;
    int chinese;
    int math;
    int english;
    int total;

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        total = chinese + math + english;
    }
}
