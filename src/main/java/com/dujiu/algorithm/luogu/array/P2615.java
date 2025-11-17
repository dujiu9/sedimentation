package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P2615 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] magic = new int[N][N];
        int r = 0;
        int c = N / 2;
        magic[r][c] = 1;
        // r是行，c为列
        for (int k = 2; k <= N * N; k++) {
            if (r == 0 && c != N - 1) {
                r = N - 1;
                c = c + 1;
            }else if (c == N -1 && r != 0) {
                r = r - 1;
                c = 0;
            }else if (r == 0 && c == N - 1) {
                r = r + 1;
            }else {
                // 尝试右上方
                int nr = r - 1;
                int nc = c + 1;
                if (magic[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }else {
                    // 正下方
                    r = r + 1;
                }
            }
            magic[r][c] = k;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(magic[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
