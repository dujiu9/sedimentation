package com.dujiu.algorithm.leetcode.weeklyCompetition.WeeklyCompetition_478;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiu
 * @description: 镜像对之间最小绝对距离
 * @date 2025/11/30
 */
public class Q3 {
    public int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                int j = map.get(cur);
                ans = Math.min(ans, i - j);
            }
            int reverse = reverse(cur);
            map.put(reverse, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s).reverse();
        return Integer.parseInt(sb.toString());
    }
}
