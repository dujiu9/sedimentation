package com.dujiu.algorithm.luogu.binarySearch;

import java.io.*;

public class P2440 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        // 原木的数量
        int n = nextInt();
        // 需要得到的小段的数量
        int k = nextInt();
        int[] woods = new int[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            woods[i] = nextInt();
            if (woods[i] > maxLength) {
                maxLength = woods[i];
            }
        }

        int left = 1;
        int right = maxLength;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
        }
    }
}
