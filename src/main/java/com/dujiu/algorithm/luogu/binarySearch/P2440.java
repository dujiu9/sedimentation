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
        int n = nextInt();
        int k = nextInt();
        int[] woods = new int[n];
        int maxLength = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            woods[i] = nextInt();
            maxLength = Math.max(maxLength, woods[i]);
            total += woods[i];
        }

        if (total < k) {
            out.print(0);
            out.flush();
            return;
        }

        // 进行二分
        int left = 1;
        int right = maxLength;
        int res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 小段的数量
            long l = 0;
            for (int wood : woods) {
                l += wood / mid;
            }

            if (l >= k) {
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        out.print(res);
        out.flush();
    }
}
