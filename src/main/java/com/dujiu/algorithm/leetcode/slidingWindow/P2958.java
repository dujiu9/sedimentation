package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiu
 * @description: 最多K个重复元素的最长子数组
 * @date 2025/11/26
 */
public class P2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int ans = 0;
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            count++;
            while (map.get(x) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                count--;
                left++;
            }

            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        P2958 p = new P2958();
        System.out.println(p.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
    }
}
