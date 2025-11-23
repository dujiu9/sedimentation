package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @description: 定长子串中元音的最大数目
 * @author dujiu
 * @date 2025/11/21 23:17
 */
public class P1456 {
    public int maxVowels(String s, int k) {
        int count = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                count++;
            }

            int l = i - k + 1;
            if (l < 0) {
                continue;
            }

            res = Math.max(res, count);
            char out = chars[l];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                count--;
            }
        }

        return res;
    }
}
