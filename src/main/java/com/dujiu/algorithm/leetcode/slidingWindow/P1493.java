package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 删掉一个元素以后全为1的最长子数组
 * @date 2025/11/24
 */
public class P1493 {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 维护窗口中0的个数
            count += 1 - nums[right];
            while (count > 1) {
                // 离开窗口
                count -= 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
