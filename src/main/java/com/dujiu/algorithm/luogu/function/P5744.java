package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            String next = sc.next();
            int age = sc.nextInt();
            int score = sc.nextInt();
            Stu stu = new Stu(next, age, score);
            System.out.println(next + " " + stu.getAge() + " " + stu.getScore());
        }
        sc.close();
    }
}

class Stu {
    String name;
    int age;
    int score;

    public Stu(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age + 1;
    }
    public int getScore() {
        int newScore = (12 * score)/10;
        if (newScore >= 600) {
            return 600;
        }
        return newScore;
    }
}
