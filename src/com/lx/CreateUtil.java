package com.lx;

/**
 * @author Werdio丶
 * @since 2020-12-02 15:14:25
 */
public class CreateUtil {

    public static ListNode createListNode(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printTree(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        System.out.print(treeNode.val + " ");
        printTree(treeNode.left);
        printTree(treeNode.right);
    }
    
}
