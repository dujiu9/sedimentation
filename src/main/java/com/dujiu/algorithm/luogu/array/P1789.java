package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 方阵r
        int n = sc.nextInt();
        boolean[][] dp = new boolean[n][n];
        // 火把
        int m = sc.nextInt();
        // 萤石
        int k = sc.nextInt();

        for (int i = 2; i <= m + 1; i++) {
            int x =  sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            // 十字：中心 + 上下左右各2格
            int[] dx = {0, -1, -2, 1, 2, 0, 0, 0, 0};
            int[] dy = {0, 0, 0, 0, 0, -1, -2, 1, 2};
            for (int j = 0; j < dx.length; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    dp[nx][ny] = true;
                }
            }

            // 四角：(x±1, y±1)
            int[][] corners = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            for (int[] d : corners) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    dp[nx][ny] = true;
                }
            }
        }

        // 处理 k 个萤石（5×5 正方形）
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            for (int dx = -2; dx <= 2; dx++) {
                for (int dy = -2; dy <= 2; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        dp[nx][ny] = true;
                    }
                }
            }
        }

        int count = 0;
        for (boolean[] booleans : dp) {
            for (boolean aBoolean : booleans) {
                if (!aBoolean) {
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
