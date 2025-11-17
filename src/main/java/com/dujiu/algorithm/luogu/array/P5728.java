package com.dujiu.algorithm.luogu.array;

import java.util.Scanner;

public class P5728 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] scores = new int[N][3];
        int count = 0;

        // 读入数据
        for (int i = 0; i < N; i++) {
            scores[i][0] = sc.nextInt(); // 语文
            scores[i][1] = sc.nextInt(); // 数学
            scores[i][2] = sc.nextInt(); // 英语
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                boolean ok = true;
                for (int k = 0; k < 3; k++) {
                    if (Math.abs(scores[i][k] - scores[j][k]) > 5) {
                        ok = false;
                        break;
                    }
                }

                // 检查总分
                if (ok) {
                    int sumI = scores[i][0] + scores[i][1] + scores[i][2];
                    int sumJ = scores[j][0] + scores[j][1] + scores[j][2];
                    if (Math.abs(sumI - sumJ) <= 10) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
