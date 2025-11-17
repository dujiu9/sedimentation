package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P2550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] win = new boolean[34];

        // 存放中奖的号码
        for (int i = 0; i < 7; i++) {
            int num = sc.nextInt();
            win[num] = true;
        }

        // 1-6等奖的中奖张数
        int[] ant = new int[7];

        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 0; j < 7; j++) {
                int num = sc.nextInt();
                if (win[num]) {
                    // 表示有相同的号码
                    index++;
                }
            }

            if (index > 0 && index <=7 ) {
                ant[7 - index]++;
            }
        }

        for (int i = 0; i < 7; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(ant[i]);
        }
        System.out.println();
        sc.close();
    }
}
