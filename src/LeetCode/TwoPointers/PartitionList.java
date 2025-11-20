package src.LeetCode.TwoPointers;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/partition-list/description/?envType=problem-list-v2&envId=two-pointers
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0); // x보다 작은거
        ListNode less = lessHead;

        ListNode greaterHead = new ListNode(0); // x보다 큰거
        ListNode greater = greaterHead;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        less.next = greaterHead.next;

        return lessHead.next;
    }
}
