package com.dujiu.algorithm.leetcode.krahets;

/**
 * @author dujiu
 * @description: 分隔链表
 * @date 2025/11/28
 */
public class P86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smlDummy  =  new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode small = smlDummy;
        ListNode big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigDummy.next;
        return smlDummy.next;
    }
}
