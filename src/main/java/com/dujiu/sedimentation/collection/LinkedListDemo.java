package com.dujiu.sedimentation.collection;

import java.util.LinkedList;

/**
 * @author dujiu
 * @date: 2025/9/28
 * @description: 学习一下linkedList的源码
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println( list);
    }
}
