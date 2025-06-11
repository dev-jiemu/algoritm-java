package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 3 pointer
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;

            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
