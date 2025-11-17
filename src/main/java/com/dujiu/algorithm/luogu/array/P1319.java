package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean flag = true; // 0
        int cnt = 0;
        while(sc.hasNext()) {
            int num = sc.nextInt();
            if (flag) {
                for (int i = 0; i < num; i++) {
                    System.out.print(0);
                    cnt++;
                    if (cnt % N == 0) {
                        System.out.println();
                    }
                }
                flag = false;
            }else {
                for (int i = 0; i < num; i++) {
                    System.out.print(1);
                    cnt++;
                    if (cnt % N == 0) {
                        System.out.println();
                    }
                }
                flag = true;
            }
        }
        sc.close();
    }
}
