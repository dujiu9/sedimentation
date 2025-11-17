package com.dujiu.algorithm.luogu.string;

import java.util.Scanner;

public class P1914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 消费换行符
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            // 将字母映射为 0~25（a=0, b=1, ..., z=25）
            int idx = c - 'a';
            // 循环移位：模 26，处理负数和大数
            int shifted = (idx + n % 26 + 26) % 26;
            // 映射回字符
            sb.append((char)('a' + shifted));
        }
        System.out.println(sb);
        sc.close();
    }
}
