package com.dujiu.algorithm.leetcode.weeklyCompetition.doubleWeeklyCompetition_177;

/**
 * @author dujiu
 * @description: 范围内总波动值1（第170场双周赛第二题）
 * @date 2025/11/22
 */
public class Q2 {
    public int totalWaviness(int num1, int num2) {
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            int count = 0;
            char[] chars = String.valueOf(i).toCharArray();
            for (int j = 1; j < chars.length - 1; j++) {
                if ((chars[j] > chars[j+1] && chars[j] > chars[j-1]) || (chars[j] < chars[j-1] && chars[j] < chars[j+1])) {
                    count++;
                }
            }
            sum += count;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q2 q = new Q2();
        System.out.println(q.totalWaviness(4848, 4848));
    }
}
