package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 大小为K且平均值大于等于阈值的子数组数目
 * @date 2025/11/23
 */
public class P1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int idx = i - k + 1;
            if (idx < 0) continue;

            int ans = sum / k;
            if (ans >= threshold) {
                count++;
            }
            sum -= arr[idx];
        }

        return count;
    }
}
