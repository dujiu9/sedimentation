package com.dujiu.algorithm.leetcode.binarySearch;

/**
 * @author dujiu
 * @description: 搜索插入位置
 * @date 2025/11/26
 */
public class P35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        if (left == nums.length || nums[left] != target) {
            return left;
        }
        return left;
    }
}
