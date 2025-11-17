package com.dujiu.algorithm.luogu.string;

import java.util.Scanner;

public class P1308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().trim().toLowerCase();
        String text = sc.nextLine().trim().toLowerCase();

        int count = 0;
        int firstPos = -1;
        int n = text.length();

        for (int i = 0; i < n; i++) {
            // 找单词开头：当前是字母，且（是开头 or 前一个不是字母）
            if (Character.isLetter(text.charAt(i))) {
                int j = i;
                // 扩展到单词结尾（连续字母）
                while (j < n && Character.isLetter(text.charAt(j))) {
                    j++;
                }
                // 提取当前单词
                String candidate = text.substring(i, j);
                if (candidate.equals(word)) {
                    count++;
                    if (firstPos == -1) {
                        firstPos = i;
                    }
                }
                i = j - 1; // for 循环会 i++，所以跳到 j-1
            }
        }

        if (count == 0) {
            System.out.println("-1");
        } else {
            System.out.println(count + " " + firstPos);
        }
        sc.close();
    }
}
