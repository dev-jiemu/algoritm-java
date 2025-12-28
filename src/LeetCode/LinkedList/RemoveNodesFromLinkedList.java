package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/remove-nodes-from-linked-list/
public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        // 뒤집고 시작
        head = this.reverse(head);

        int maxSoFar = 0;
        ListNode curreent = head;
        ListNode prev = null;

        while (curreent != null) {
            if (curreent.val >= maxSoFar) {
                maxSoFar = curreent.val;
                prev = curreent;
            } else {
                prev.next = curreent.next;
            }
            curreent = curreent.next;
        }

        // 다시 뒤집음
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
