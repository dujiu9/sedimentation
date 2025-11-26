package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 最大连续1的个数 III
 * @date 2025/11/26
 */
public class P1004 {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int count1 = 0;
        int count0 = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == 1) {
                count1++;
            }else {
                count0++;
            }

            while (count0 > k) {
                if (nums[j] == 1) {
                    count1--;
                }else {
                    count0--;
                }
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
