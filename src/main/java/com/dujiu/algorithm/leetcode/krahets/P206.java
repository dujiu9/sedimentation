package com.dujiu.algorithm.leetcode.krahets;

/**
 * @author dujiu
 * @description: 反转链表
 * @date 2025/11/28
 */
public class P206 {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    // 双指针
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null; // 前指针
        ListNode cur = head; // 当前节点指针
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    // 递归
    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp, cur);
    }
}
