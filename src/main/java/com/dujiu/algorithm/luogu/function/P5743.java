package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5743 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int sum = 1;
        for (int i = 1; i < day; i++) {
            sum += 1;
            sum = sum*2;
        }
        sc.close();
        System.out.println(sum);
    }
}
