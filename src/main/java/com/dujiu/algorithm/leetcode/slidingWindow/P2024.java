package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 考试的最大困扰度
 * @date 2025/11/26
 */
public class P2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        char[] array = answerKey.toCharArray();
        int t = 0, f = 0, j = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == 'T') {
                t++;
            }else {
                f++;
            }

            while (t > k && f > k) {
                if (array[j] == 'T') {
                    t--;
                }else {
                    f--;
                }
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
