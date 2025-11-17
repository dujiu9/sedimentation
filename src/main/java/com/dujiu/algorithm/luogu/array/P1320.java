package com.dujiu.algorithm.luogu.array;

import java.util.*;

public class P1320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        // 读取所有非空行（直到 EOF）
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                lines.add(line);
            }
        }
        sc.close();

        int n = lines.size();  // N = 行数
        if (n == 0) {
            System.out.println("0");
            return;
        }

        // 拼接成完整字符串
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        String s = sb.toString();

        // 游程编码：从 '0' 开始
        char prev = '0';
        int count = 0;
        List<Integer> runs = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                runs.add(count);
                count = 1;
                prev = c;
            }
        }
        runs.add(count);

        // 输出：N + 游程
        System.out.print(n);
        for (int x : runs) {
            System.out.print(" " + x);
        }
        System.out.println();
    }
}
