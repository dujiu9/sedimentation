package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dujiu
 * @description: 几乎唯一子数组的最大和
 * @date 2025/11/23
 */
public class P2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        Integer[] arr = nums.toArray(Integer[]::new);
        long sum = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // 进入窗口
            sum += arr[i];
            map.merge(arr[i], 1, Integer::sum);
            int l = i - k + 1;
            if (l < 0) continue;

            // 更新答案
            if (map.size() >= m) {
                ans = Math.max(sum, ans);
            }

            // 离开窗口
            int out = arr[l];
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
