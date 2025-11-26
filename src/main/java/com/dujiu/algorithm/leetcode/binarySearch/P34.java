package com.dujiu.algorithm.leetcode.binarySearch;

/**
 * @author dujiu
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @date 2025/11/26
 */
public class P34 {
    public int[] searchRange(int[] nums, int target) {
        int start = lower_bound(nums, target);
        int end = lower_bound(nums, target + 1) - 1;

        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{start, end};
    }

    private static int lower_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
