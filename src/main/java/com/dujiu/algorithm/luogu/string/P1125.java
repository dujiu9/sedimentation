package com.dujiu.algorithm.luogu.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class P1125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        // 最大频次
        int maxFreq = Collections.max(hashMap.values());
        int minFreq = Collections.min(hashMap.values());
        int result  = maxFreq - minFreq;
        if (isPrime(result)) {
            System.out.println("Lucky Word");
            System.out.println(result);
        }else {
            System.out.println("No Answer");
            System.out.println(0);
        }

    }

    private static boolean isPrime(int n) {
        // 小于 2 的数不是质数
        if (n < 2) {
            return false;
        }
        // 2 是唯一的偶质数
        if (n == 2) {
            return true;
        }
        // 排除所有偶数（>2）
        if (n % 2 == 0) {
            return false;
        }

        // 只需检查到 sqrt(n)，且只试奇数因子：3, 5, 7, ...
        // 注意：用 i * i <= n 避免浮点运算误差（比 Math.sqrt(n) 更安全）
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
