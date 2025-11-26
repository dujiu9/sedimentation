package com.dujiu.algorithm.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiu
 * @description: 每个字符最多出现两次的最长字字符串
 * @date 2025/11/24
 */
public class P3090 {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 进入窗口
            char in = s.charAt(i);
            map.merge(in, 1, Integer::sum);

            // 离开窗口
            while (map.get(in) > 2) {
                char out = s.charAt(left);
                map.put(out, map.get(out) - 1);
                left++;
            }

            // 更新答案
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
