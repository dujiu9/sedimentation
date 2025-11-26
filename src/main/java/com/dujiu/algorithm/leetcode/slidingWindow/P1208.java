package com.dujiu.algorithm.leetcode.slidingWindow;

/**
 * @author dujiu
 * @description: 尽可能使字符串相等
 * @date 2025/11/26
 */
public class P1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int ans = 0;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            sum += cost[i];
            if (sum > maxCost) {
                sum -= cost[left];
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        P1208 p = new P1208();
//        System.out.println(p.equalSubstring("abcd", "bcdf", 3));
//        System.out.println(p.equalSubstring("abcd", "cdef", 3));
        System.out.println(p.equalSubstring("abcd", "acde", 0));
    }
}
