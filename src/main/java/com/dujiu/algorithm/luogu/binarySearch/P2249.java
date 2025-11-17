package com.dujiu.algorithm.luogu.binarySearch;

import java.io.*;

public class P2249 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            array[i] = (int) in.nval;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            in.nextToken();
            int num = (int) in.nval;
            int res = binarySearch(array, num);
            sb.append(res);
            if (i != m -1) {
                sb.append(" ");
            }
        }
        out.print(sb);
        out.flush();
    }

    private static int binarySearch(int[] array, int n) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == n) {
                result = mid;
                right = mid - 1;
            }else if (array[mid] > n) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return result != -1 ? result + 1 : -1;
    }
}
