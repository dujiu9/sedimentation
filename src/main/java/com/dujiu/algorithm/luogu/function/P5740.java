package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String topName = "";
        int topChinese = 0;
        int topMath = 0;
        int topEnglish = 0;
        int topTotal = -1;

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int chinese = sc.nextInt();
            int math = sc.nextInt();
            int english = sc.nextInt();

            int total = chinese + math + english;

            if (total > topTotal) {
                topName = name;
                topChinese = chinese;
                topMath = math;
                topEnglish = english;
                topTotal = total;
            }
        }

        sc.close();
        System.out.print(topName + " " + topChinese + " " + topMath + " " + topEnglish);
    }
}
