package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P5731 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = 0, c = 0;
        // 0=右，1=下，2=左，3=上
        int dir = 0;
        int[][] arr = new int[n][n];
        for (int i = 1; i <= n * n; i++) {
            arr[r][c] = i;
            int nr = r, nc = c;
            if (dir == 0) nc++;
            else if (dir == 1) nr++;
            else if (dir == 2) nc--;
            else if (dir == 3) nr--;

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != 0) {
                dir = (dir + 1) % 4;

                if (dir == 0) {
                    nr = r;
                    nc = c + 1;
                }else if (dir == 1) {
                    nr = r + 1;
                    nc = c;
                }else if (dir == 2) {
                    nr = r;
                    nc = c - 1;
                }else if (dir == 3) {
                    nr = r - 1;
                    nc = c;
                }
            }

            r = nr;
            c = nc;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
