package com.dujiu.algorithm.luogu.binarySearch;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class P1102 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        in.nextToken(); int N = (int) in.nval;
        in.nextToken(); int C = (int) in.nval;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            in.nextToken();
            int x = (int) in.nval;
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        long count = 0;
        for (int x : freq.keySet()) {
            int y = x + C;
            if (freq.containsKey(y)) {
                long cntX = freq.get(x);
                long cntY = freq.get(y);
                count += cntX * cntY;
            }
        }
        out.print(count);
        out.flush();
    }
}
