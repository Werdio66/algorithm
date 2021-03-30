package com.lx.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Werdio丶
 * @since 2021-02-02 09:15:40
 */
public class 复杂链表的复制 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        while (cur != null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head.next;
        Node prev = head, res = cur;
        while (cur.next != null){
            prev.next = prev.next.next;
            cur.next = cur.next.next;
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = null;
        return res;
    }
}

class Node {
    int val;
    Node next, random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
