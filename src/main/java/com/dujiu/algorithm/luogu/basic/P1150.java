package com.dujiu.algorithm.luogu.basic;

import java.util.Scanner;

public class P1150 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long total = 0;
        if (n < k) {
            total = n;
        }else {
            total = n + (n - 1) / (k - 1);
        }
        System.out.println(total);
        sc.close();
    }
}
