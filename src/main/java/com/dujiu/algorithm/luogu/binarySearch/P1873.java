package com.dujiu.algorithm.luogu.binarySearch;

import java.io.*;

public class P1873 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        // 树木的数量
        int N = nextInt();
        // 需要的木材总长度
        long M = nextInt();

        int[] tress = new int[N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            tress[i] = nextInt();
            if (tress[i] > maxHeight) {
                maxHeight = tress[i];
            }
        }

        // 二分查找最大H
        int low = 0;
        int high = maxHeight;
        while (low < high) {
            int mid = (low + high + 1) >>> 1;
            if (getWood(tress, mid) >= M) {
                low = mid;
            }else {
                high = mid - 1;
            }
        }

        out.println(low);
        out.flush();
    }

    private static long getWood(int[] trees, int H) {
        long total = 0;
        for (int h : trees) {
            if (h > H) {
                total += (long) h - H;
            }
        }
        return total;
    }
}
