package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] b = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            double a = sc.nextDouble();
            double t = sc.nextInt();
            for (int j = 1; j <= t; j++) {
                b[(int)(Math.floor(a*j))] = !b[(int) (Math.floor(a * j))];
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}
