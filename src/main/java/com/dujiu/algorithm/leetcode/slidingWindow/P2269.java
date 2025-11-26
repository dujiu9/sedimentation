package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 找到一个数字的K美丽值
 * @date 2025/11/24
 */
public class P2269 {
    public int divisorSubstrings(int num, int k) {
        int ans = 0;
        String line = String.valueOf(num);
        for (int left = 0, right = k; right <= line.length(); left++, right++) {
            int res = Integer.parseInt(line.substring(left, right));
            if (res != 0 && num % res == 0) {
                ans++;
            }
        }
        return ans;
    }
}
