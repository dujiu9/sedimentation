package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1428 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }
}
