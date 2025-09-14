package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        // dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while(current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            current.next = second;
            second.next = first;

            current = first;
        }

        return dummy.next;
    }
}
