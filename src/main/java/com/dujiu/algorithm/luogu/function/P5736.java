package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (isPrime(arr[i])) {
                // 是质数
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false; // 排除所有偶数 >2

        // 只检查奇数因子：3, 5, 7, ..., √n
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
