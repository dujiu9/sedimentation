package com.dujiu.sedimentation.collection;

import java.util.ArrayList;

/**
 * @author dujiu
 * @date: 2025/9/25
 * @description: 学习一下arrayList的源码
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(11);
        System.out.println( list);
    }
}
