package com.dujiu.algorithm.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @author dujiu
 * @description: 和有限的最长子序列
 * @date 2025/11/27
 */
public class P2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        for (int i = 0; i < queries.length; i++) {
            queries[i] = lower_bound(nums, queries[i]);
        }
        return queries;
    }

    private int lower_bound(int[] nums, int target) {
        int l = -1, r = nums.length;
        while (l + 1 < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid;
            }else {
                l = mid;
            }
        }
        return r;
    }
}
