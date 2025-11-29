package com.dujiu.algorithm.leetcode.krahets;

/**
 * @author dujiu
 * @description: 删除链表中的节点
 * @date 2025/11/28
 */
public class P237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
