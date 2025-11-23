package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 得到K个黑块的最少涂色次数
 * @date 2025/11/23
 */
public class P2379 {
    public int minimumRecolors(String blocks, int k) {
        int ans = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                ans++;
            }

            if (i < k -1){
                continue;
            }

            res = Math.min(res, ans);
            char c = blocks.charAt(i - k + 1);
            if (c == 'W') {
                ans--;
            }
        }
        return res;
    }
}
