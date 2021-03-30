package com.lx.offer;

import com.lx.ListNode;

/**
 * @author Werdio丶
 * @since 2021-01-28 19:04:29
 */
public class 删除链表中的结点 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode deletedNode = head.next;
        ListNode prev = head;
        if (head.val == val){
            return deletedNode;
        }
        while (deletedNode.val != val){
            prev = prev.next;
            deletedNode = deletedNode.next;
        }
        prev.next = deletedNode.next;
        return head;
    }
}
