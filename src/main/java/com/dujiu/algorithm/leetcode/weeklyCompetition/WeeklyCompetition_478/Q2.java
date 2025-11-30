package com.dujiu.algorithm.leetcode.weeklyCompetition.WeeklyCompetition_478;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiu
 * @description: 不同首字母的子字符串数目
 * @date 2025/11/30
 */
public class Q2 {
    public int maxDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.size();
    }
}
