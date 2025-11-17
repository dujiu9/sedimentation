package com.dujiu.algorithm.luogu.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P2141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            set.add(nums[i]);
        }

        Set<Integer> found = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (set.contains(sum)) {
                    found.add(sum);
                }
            }
        }

        System.out.println(found.size());
        sc.close();
    }
}
