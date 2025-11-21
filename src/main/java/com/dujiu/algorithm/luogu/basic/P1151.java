package com.dujiu.algorithm.luogu.basic;

import java.util.Scanner;

public class P1151 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int count = 0;
        for (int i = 10000; i <= 30000; i++) {
            int sub1 = Integer.parseInt(String.valueOf(i).substring(0,3));
            int sub2 = Integer.parseInt(String.valueOf(i).substring(1,4));
            int sub3 = Integer.parseInt(String.valueOf(i).substring(2,5));

            if (sub1 % K == 0 && sub2 % K == 0 && sub3 % K == 0) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No");
        }
        sc.close();
    }
}
