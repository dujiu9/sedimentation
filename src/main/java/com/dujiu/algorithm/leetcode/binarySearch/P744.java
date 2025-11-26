package com.dujiu.algorithm.leetcode.binarySearch;

/**
 * @author dujiu
 * @description: 寻找比目标字母大的最小字母
 * @date 2025/11/26
 */
public class P744 {
    public char nextGreatestLetter(char[] letters, char target) {
        // 左闭右开
        int l = 0, r = letters.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return letters[l % letters.length];
    }
}
