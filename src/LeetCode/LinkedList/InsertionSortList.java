package src.LeetCode.LinkedList;


import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/insertion-sort-list/description/?envType=problem-list-v2&envId=linked-list
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // dummy
        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;

            ListNode prev = dummy;
            while(prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            current.next = prev.next;
            prev.next = current;

            current = next;
        }

        return dummy.next;
    }
}
