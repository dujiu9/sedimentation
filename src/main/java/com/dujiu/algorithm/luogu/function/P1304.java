package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P1304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int i = 4; i <= N; i+=2) {
            for (int j = 2; j <= i/2 ; j++) {
                int k = i - j;
                if (isPrime(j) && isPrime(k)) {
                    System.out.println(i + "=" + j + "+" + k);

                    break;
                }
            }
        }
    }

    // 判断是否是质数
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
