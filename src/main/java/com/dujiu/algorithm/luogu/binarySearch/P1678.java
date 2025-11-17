package com.dujiu.algorithm.luogu.binarySearch;

import java.io.*;
import java.util.Arrays;

public class P1678 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
    public static void main(String[] args) throws IOException {
        int m = nextInt();
        int n = nextInt();
        int[] scores = new int[m];

        for (int i = 0; i < m; i++) {
            scores[i] = nextInt();
        }

        Arrays.sort(scores); // 关键：排序后才能二分

        long total = 0; // 注意：最坏 1e5 * 1e9 = 1e14，必须用 long！
        for (int i = 0; i < n; i++) {
            int stu = nextInt(); // 学生成绩
            int diff = minDiff(scores, stu);
            total += diff;
        }

        out.print(total);
        out.flush();
    }

    static int minDiff(int[] scores, int x) {
        int left = 0;
        int right = scores.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (scores[mid] >= x) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        if (left < scores.length) {
            minDiff = Math.min(minDiff, scores[left] - x);
        }

        if (left > 0) {
            minDiff = Math.min(minDiff, x - scores[left - 1]);
        }
        return minDiff;
    }
}
