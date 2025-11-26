package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dujiu
 * @description: 找出数组中的所有K近邻下标
 * @date 2025/11/24
 */
public class P2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == key && Math.abs(i-j) <= k) {
                    set.add(j);
                }
            }
        }
        return set.stream().sorted().toList();
    }
}
