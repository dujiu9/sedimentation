package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.Arrays;

/**
 * @author dujiu
 * @description: 半径为k的子数组平均值
 * @date 2025/11/23
 */
public class P2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        Arrays.fill(avgs, -1);
        long sum = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < 2*k) {
                continue;
            }

            avgs[i-k] = (int) (sum / (2*k+1));
            sum -= nums[idx++];
        }

        return avgs;
    }
}
