package com.dujiu.algorithm.luogu.function;

import java.util.Scanner;

public class P5461 {
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = 1 << n;
        matrix = new int[length][length];

        // 初始化为1，不赦免
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = 1;
            }
        }

        // 迭代方法：按块大小逐步赦免
        for (int blockSize = length; blockSize >= 2; blockSize /= 2) {
            int half = blockSize / 2;
            for (int i = 0; i < length; i += blockSize) {
                for (int j = 0; j < length; j += blockSize) {
                    // 赦免每个块的左上角子块
                    for (int x = i; x < i + half; x++) {
                        for (int y = j; y < j + half; y++) {
                            matrix[x][y] = 0;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(matrix[i][j]);
                if (j < length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

