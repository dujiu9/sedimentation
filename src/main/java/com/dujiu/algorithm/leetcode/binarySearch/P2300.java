package com.dujiu.algorithm.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @author dujiu
 * @description: 咒语和药水的成功对数
 * @date 2025/11/27
 */
public class P2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            spells[i] = potions.length - lower_bound(potions, (double) success / spells[i]);
        }
        return spells;
    }

    private static int lower_bound(int[] nums, double target) {
        int l = -1, r = nums.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            }else {
                l = mid;
            }
        }
        return r;
    }
}
