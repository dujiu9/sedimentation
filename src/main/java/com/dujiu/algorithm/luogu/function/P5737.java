package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5737 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count = 0;
        int[] arr = new int[y-x+1];
        for (int i = x; i <= y; i++) {
            if (isTrue(i)) {
                arr[count++] = i;
            }
        }
        System.out.println(count);
        for (int i : arr) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isTrue(int year) {
        // 判断是不是闰年
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}
