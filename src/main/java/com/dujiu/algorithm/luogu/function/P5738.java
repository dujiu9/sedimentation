package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        double maxScore = -1.0;
        for (int i = 0; i < n; i++) {
            int[] scores = new int[m];
            int sum = 0;
            int min = 11;
            int max = -1;
            for (int j = 0; j < m; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
                if (scores[j] < min) min = scores[j];
                if (scores[j] > max) max = scores[j];
            }

            // 去掉一个最高分、一个最低分
            double avg = (double)(sum - max - min) / (m - 2);
            if (avg > maxScore) {
                maxScore = avg;
            }
        }
        System.out.printf("%.2f%n", maxScore);
    }
}
