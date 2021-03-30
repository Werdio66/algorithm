package com.lx.leetcode;

import com.lx.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2021-02-26 09:42:38
 */
public class 相交链表 {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode res = null;
        while (headA != null){
            res = judge(headA, headB);
            if (res != null){
                break;
            }
            headA = headA.next;
        }
        return res;
    }

    private ListNode judge(ListNode headA, ListNode headB) {
        while (headB != null){
            if (headA == headB){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode res = null;

        Map<ListNode, ListNode> map = new HashMap<>();
        while (headA != null){
            map.put(headA, headA);
            headA = headA.next;
        }
        while (headB != null){
            if (map.containsKey(headB)){
                res = headB;
                break;
            }
            headB = headB.next;
        }
        return res;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb){
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;
    }
}
