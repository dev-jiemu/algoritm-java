package src.LeetCode.DivideAndConquer;

import src.LeetCode.common.ListNode;

import java.util.List;

// https://leetcode.com/problems/sort-list/?envType=study-plan-v2&envId=top-interview-150
public class SortList {
    // Divide and Conquer
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null; // 분할
        }

        return slow;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                current.next = n1;
                n1 = n1.next;
            } else {
                current.next = n2;
                n2 = n2.next;
            }
            current = current.next;
        }

        if (n1 != null) current.next = n1;
        if (n2 != null) current.next = n2;

        return dummy.next;
    }
}
