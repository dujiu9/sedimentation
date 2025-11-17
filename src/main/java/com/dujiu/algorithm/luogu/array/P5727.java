package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P5727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int[] array = new int[10000];
        while(true) {
            if (n == 1) {
                array[count++] = n;
                break;
            }
            array[count++] = n;
            if (n % 2 == 0) {
                // 偶数
                n /= 2;
            }else {
                n = 3 * n + 1;
            }
        }

        for (int i = count -1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
