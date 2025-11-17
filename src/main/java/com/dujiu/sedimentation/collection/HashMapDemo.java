package com.dujiu.sedimentation.collection;

import java.util.HashMap;

/**
 * @author dujiu
 * @date: 2025/10/7
 * @description: 学习一下hashMap的源码
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i <= 11; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }

        map.put("12","12");
        map.get("12");
        System.out.println(map);
    }
}
