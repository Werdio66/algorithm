package com.lx.offer;

import com.lx.ListNode;

/**
 * @author Werdio丶
 * @since 2021-02-25 16:53:19
 */
public class 判断链表是否有环 {

    private static ListNode judge(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
