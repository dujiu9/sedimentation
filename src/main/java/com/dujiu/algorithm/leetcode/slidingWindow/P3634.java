package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.Arrays;

/**
 * @author dujiu
 * @description: 使数组平衡的最少移除数目
 * @date 2025/11/26
 */
public class P3634 {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSave = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((long)nums[left] * k < nums[right]) {
                left++;
            }

            maxSave = Math.max(maxSave, right - left + 1);
        }
        return nums.length - maxSave;
    }
}
