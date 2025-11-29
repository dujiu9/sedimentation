package com.dujiu.algorithm.leetcode.krahets;


/**
 * @author dujiu
 * @description: 合并两个有序链表
 * @date 2025/11/28
 */
public class P21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        // 此时list1和list2均不为null
        ListNode res = list1.val < list2.val ? list1 : list2;
        res.next = mergeTwoLists(res.next, list1.val < list2.val ? list1 : list2);
        return res;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curNode.next = list1;
                list1 = list1.next; // 这里是因为list1是指针
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }

        curNode.next = list1 == null ? list2 : list1;
        return head.next;
    }
}

