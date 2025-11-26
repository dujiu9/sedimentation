package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiu
 * @description: 删除子数组的最大得分
 * @date 2025/11/26
 */
public class P1695 {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        int left = 0;
        for (int num : nums) {
            sum += num;
            map.merge(num, 1, Integer::sum);

            while (map.get(num) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }

            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        P1695 p = new P1695();
        System.out.println(p.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}
