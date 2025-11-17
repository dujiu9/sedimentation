package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // 处理 m=0 的特殊情况
        if (m == 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int sum = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            if (i < m - 1) {
                continue;
            }

            max = Math.min(max, sum);
            sum -= array[i+1-m];
        }

        System.out.println(max);
        sc.close();
    }
}
