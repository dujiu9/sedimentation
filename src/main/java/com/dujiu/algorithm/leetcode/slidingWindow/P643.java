package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 子数组最大平均数 I
 * @date 2025/11/22
 */
public class P643 {
    public double findMaxAverage(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 进入窗口
            sum += nums[i];
            int idx = i - k + 1;
            if (idx < 0) {
                continue;
            }

            // 修改答案
            ans = Math.max(ans, sum);

            // 离开窗口
            sum -= nums[idx];
        }

        return (double) ans / k;
    }
}
