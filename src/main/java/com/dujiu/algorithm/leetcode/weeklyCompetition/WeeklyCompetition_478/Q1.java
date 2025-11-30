package com.dujiu.algorithm.leetcode.weeklyCompetition.WeeklyCompetition_478;

import java.util.Arrays;

/**
 * @author dujiu
 * @description: 统计合格元素的数目
 * @date 2025/11/30
 */
public class Q1 {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int num : nums) {
            int index = binarySearch(nums, num);
            if (n - index >= k) {
                count++;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int target) {
        int l = -1, r = nums.length;
        while (l + 1 < r) {
            int mid = l + ((r- l) >> 1);
            if (nums[mid] > target) {
                r = mid;
            }else {
                l = mid;
            }
        }
        return r;
    }
}
