package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
public class DeletetheMiddleNodeofaLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        // total length check
        int length = 0;
        ListNode current = head;
        while(current != null) {
            length++;
            current = current.next;
        }

        int middle = length / 2;
        current = head;
        for (int i = 0; i < middle - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return head;
    }

    // two pointer 로도 풀수 있다고함
    public ListNode deleteMiddleTwoPointer(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head; // 1칸이동
        ListNode fast = head; // 2칸이동
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
