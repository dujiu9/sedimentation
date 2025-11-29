package com.dujiu.algorithm.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @author dujiu
 * @description: 两个数组间的距离值
 * @date 2025/11/27
 */
public class P1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int k : arr1) {
            if (!binarySearch(arr2, k, d)) {
                count++;
            }
        }
        return count;
    }

    private static boolean binarySearch(int[] nums, int x, int d) {
        int n = nums.length;
        int l = 0, r = nums.length - 1;
        int ans = n;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= x) {
                ans = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        if (ans < n && Math.abs(nums[ans] - x) <= d) return true;
        if (ans > 0 && Math.abs(nums[ans - 1] - x) <= d) return true;
        return false;
    }
}
