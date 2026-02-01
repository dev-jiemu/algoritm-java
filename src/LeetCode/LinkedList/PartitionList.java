package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/partition-list/description/?envType=problem-list-v2&envId=linked-list
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);   // x 미만
        ListNode greaterHead = new ListNode(0); // x 이상

        ListNode less = lessHead;
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
