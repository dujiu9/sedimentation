package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 可获得的最大点数
 * @date 2025/11/23
 */
public class P1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int len = cardPoints.length;
        int n = len - k; // 剩下的
        int res = 0;
        for (int cardPoint : cardPoints) {
            res += cardPoint;
        }

        for (int i = 0; i < n; i++) {
            sum += cardPoints[i];
        }
        int ans = sum;

        for (int i = n; i < len; i++) {
            sum += cardPoints[i];
            sum -= cardPoints[i - n];
            ans = Math.min(ans, sum);
        }

        return n > 0 ? res - ans : res;
    }
}
