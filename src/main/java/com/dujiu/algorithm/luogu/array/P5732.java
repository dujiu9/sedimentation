package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P5732 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[n+1];

            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }

        // 输出：每行数字间一个空格，末尾无多余空格/换行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
