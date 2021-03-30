package com.lx.leetcode;

import com.lx.ListNode;

/**
 * @author Werdio丶
 * @since 2021-03-03 09:22:38
 */
public class k个一组翻转链表 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        ListNode end = node;
        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return node.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
