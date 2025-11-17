package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1554 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] nums = new int[10];
        for (int i = M; i <= N; i++) {
            String str = (i + "");
            String[] s = str.split("");
            for (int j = 0; j < s.length; j++) {
                nums[Integer.parseInt(s[j])]++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(nums[i]);
        }
        sc.close();
    }
}
