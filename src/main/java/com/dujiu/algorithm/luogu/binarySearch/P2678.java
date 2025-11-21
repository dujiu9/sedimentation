package com.dujiu.algorithm.luogu.binarySearch;

import java.util.Scanner;

public class P2678 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 起点到终点的距离
        int L = sc.nextInt();
        // 起点到终点之间的岩石数
        int N = sc.nextInt();
        // 最多移走的岩石数
        int M = sc.nextInt();
        int max = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            max = Math.max(max, num);
            arr[i] = num;
        }

        int res = 0;
        int left = 1;
        int right = L;
        while (left <= right) {
            int mid = left + (right - left) / 2;

        }
    }
}
