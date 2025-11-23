package com.dujiu.algorithm.leetcode.weeklyCompetition.doubleWeeklyCompetition_177;

/**
 * @author dujiu
 * @description: 字典序最小和为目标值且绝对值是排序的数组（第170场双周赛第三题）
 * @date 2025/11/22
 */
public class Q3 {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum = (long) n * (n+1)/2;

        if (Math.abs(target) > sum) {
            return new int[0];
        }

        if ((sum - target) % 2!=0) {
            return new int[0];
        }

        // 负数绝对值之和
        long neededNegSum = (sum - target) / 2;
        boolean[] flag = new boolean[n+1];
        for (int i = n; i >= 1; i--) {
            if (i <= neededNegSum) {
                flag[i] = true;
                neededNegSum -= i;
            }
            if (neededNegSum == 0) break;
        }

        // 放入所有负数
        int[] ans = new int[n];
        int idx = 0;
        for (int i = n; i >= 1; i--) {
            if (flag[i]) {
                ans[idx++] = -i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                ans[idx++] = i;
            }
        }

        return ans;
    }
}
