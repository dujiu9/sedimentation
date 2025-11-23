package com.dujiu.algorithm.leetcode.weeklyCompetition.doubleWeeklyCompetition_177;

/**
 * @author dujiu
 * @description: 最少反转次数得到翻转二进制字符串（第170场双周赛第一题）
 * @date 2025/11/22
 */
public class Q1 {
    public int minimumFlips(int n) {
        // 将整数n转换为其对应的二进制字符串表示
        String str = Integer.toBinaryString(n);
        // 反转字符串
        String reverse_str = new StringBuffer(str).reverse().toString();
        int count = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != reverse_str.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
