package com.dujiu.algorithm.luogu.string;

import java.util.Scanner;

public class P1957 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        char defaultOp = ' ';
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] split = line.split("\\s+");

            if (split.length == 2) {
                char op = defaultOp;
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                int result = calc(a,b,op);
                String symbol = getSymbol(op);
                String expr = a + symbol + b + "=" + result;
                output.append(expr).append("\n").append(expr.length()).append("\n");
            }else if (split.length == 3) {
                char op = split[0].charAt(0);
                int a = Integer.parseInt(split[1]);
                int b = Integer.parseInt(split[2]);
                int result = calc(a,b,op);
                String symbol = getSymbol(op);
                String expr = a + symbol + b + "=" + result;
                output.append(expr).append("\n").append(expr.length()).append("\n");
                defaultOp = op;
            }
        }

        System.out.println(output);
        sc.close();
    }

    // 计算结果
    private static int calc(int a, int b, char op) {
        switch (op) {
            case 'a': return a + b;
            case 'b': return a - b;
            case 'c': return a * b;
            default:  return 0; // 不会走到这里
        }
    }

    // 获取运算符符号
    private static String getSymbol(char op) {
        switch (op) {
            case 'a': return "+";
            case 'b': return "-";
            case 'c': return "*";
            default:  return "";
        }
    }
}
