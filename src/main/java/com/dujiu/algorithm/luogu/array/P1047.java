package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int M = sc.nextInt();
        Boolean[] tree = new Boolean[L + 1];
        for (int i = 0; i <= L; i++) {
            tree[i] = true;
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            for (int j = u; j <= v; j++) {
                tree[j] = false;
            }
        }

        int count = 0;
        for (int i = 0; i <= L; i++) {
            if (tree[i]) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
