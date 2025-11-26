package com.dujiu.algorithm.leetcode.binarySearch;

/**
 * @author dujiu
 * @description: 二分查找
 * @date 2025/11/26
 */
public class P704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
