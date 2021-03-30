package com.lx.leetcode;

import com.lx.CreateUtil;
import com.lx.ListNode;

/**
 * @author Werdio丶
 * @since 2021-03-15 19:22:31
 */
public class 使字符串变成回文串 {

    private static String getString(String s){
        String res = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {

        }
        return "";
    }

    private static ListNode remove(ListNode head, int id){
        while (head.val == id){
            head = head.next;
        }
        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur != null){
            while (cur.val == id){
               cur = cur.next;
               if (cur == null){
                   prev.next = cur;
                   return head;
               }
            }
            prev.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = CreateUtil.createListNode(new int[]{6, 6, 6, 1, 2, 3, 6, 6, 4, 5, 6, 6, 6});
        CreateUtil.printList(head);
        ListNode node = remove(head, 6);
        CreateUtil.printList(node);
    }
}
