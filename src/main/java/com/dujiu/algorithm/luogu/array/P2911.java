package com.dujiu.algorithm.luogu.array;

import java.util.*;

public class P2911 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int S3 = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    int num = i + j + k;
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
        }

        // 最大频次
        int maxFreq = Collections.max(map.values());

        int min = map.entrySet().stream()
                .filter(e -> e.getValue() == maxFreq)
                .mapToInt(Map.Entry::getKey)
                .min()
                .orElse(-1);
        System.out.println(min);
        sc.close();
    }
}
