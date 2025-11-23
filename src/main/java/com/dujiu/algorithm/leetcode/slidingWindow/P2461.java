package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiu
 * @description: 长度为K子数组的最大和
 * @date 2025/11/23
 */
public class P2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 进入窗口
            sum += nums[i];
            map.merge(nums[i], 1, Integer::sum);
            int l = i - k + 1;
            if (l < 0) continue;

            // 更新答案
            if (map.size() >= k) {
                ans = Math.max(sum, ans);
            }

            // 离开窗口
            int out = nums[l];
            sum -= out;
            int value = map.get(out);
            if (value > 1) {
                // out这个key重复
                map.put(out, value - 1);
            } else {
                map.remove(out);
            }
        }
        return ans;
    }
}
