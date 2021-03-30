package com.lx.leetcode;

import com.lx.CreateUtil;
import com.lx.ListNode;

import java.util.List;

/**
 * @author Werdio丶
 * @since 2020-12-02 15:07:31
 */
public class 反转链表 {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp;

        while (head != null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode head) {
        if (head.next == null){
            return head;
        }
        ListNode last = reverseList1(head.next);
        // 反转
        head.next.next = head;
        // 将原来的指针设为空
        head.next = null;
        return last;
    }

    /**
     *  反转前 n 个结点
     * @param head
     * @return
     */
    static ListNode next = null;   // 记录反转结点的下一个结点
    public static ListNode reverseListN(ListNode head, int n) {
        if (n == 1){
            next = head.next;
            return head;
        }
        ListNode last = reverseListN(head.next, n - 1);
        // 反转
        head.next.next = head;
        // 将原来的指针设为空
        head.next = next;
        return last;
    }

    /**
     * `   反转区间中的内容
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseListMN(ListNode head, int m, int n) {
        if (m == 1){
            return reverseListN(head, n);
        }
        head.next = reverseListMN(head.next, m - 1, n - 1);
        return head;
    }

    /**
     *   反转链表   m - n 之间
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {

         ListNode pre = null;
         ListNode cur = head;
         // 找到第一个反转结点
         while (m > 1){
             pre = cur;
             cur = cur.next;
             m--;
             n--;
         }
         ListNode con = pre;
         ListNode tail = cur;
         ListNode temp;
         while (n-- > 0){
             temp = cur.next;
             cur.next = pre;
             pre = cur;
             cur = temp;
         }
         if (con == null){
             head = pre;
         }else {
             con.next = pre;
         }
         tail.next = cur;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = CreateUtil.createListNode(new int[]{1, 2, 3, 4, 5});
        CreateUtil.printList(head);
//        ListNode node = reverseList1(head);
//        CreateUtil.printList(node);
//        ListNode node1 = reverseListN(head, 3);
//        CreateUtil.printList(node1);
//        ListNode node2 = reverseListMN(head, 2, 4);
        ListNode node2 = reverseBetween(head, 2, 4);
        CreateUtil.printList(node2);
    }
}
