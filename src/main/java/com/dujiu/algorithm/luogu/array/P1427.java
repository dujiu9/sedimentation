package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[100];
        int count = 0;
        while(true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            array[count++] = num;
        }

        // 倒序输出
        for (int i = count - 1; i >= 0; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
