package com.dujiu.algorithm.leetcode.binarySearch;

/**
 * @author dujiu
 * @description: 正整数和负整数的最大计数
 * @date 2025/11/26
 */
public class P2529 {
    public int maximumCount(int[] nums) {
        int neg = lowerBound(nums, 0);
        int pos = nums.length - lowerBound(nums, 1);
        return Math.max(neg, pos);
    }

    private static int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
