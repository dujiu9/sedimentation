package com.dujiu.algorithm.luogu.binarySearch;

import java.io.*;

public class P1024 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    static double f(double a, double b, double c, double d, double x) {
        return ((a * x + b) * x + c) * x + d; // 秦九韶，快+准
    }

    public static void main(String[] args) throws IOException {
        double a = nextDouble();
        double b = nextDouble();
        double c = nextDouble();
        double d = nextDouble();

        double lastRoot = -100;
        for (double x = -100; x <= 100; x+= 0.001) {
            double fx = f(a, b, c, d, x);
            if (Math.abs(fx) < 1e-3) {
                // 去重：与上一个根距离 > 0.5（题目保证根距 ≥1，安全）
                if (x - lastRoot > 0.5) {
                    out.printf("%.2f ", x);
                    lastRoot = x;
                }
            }
        }
        out.flush();
    }
}
