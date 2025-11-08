package src.LeetCode.TwoPointers;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/reorder-list/?envType=problem-list-v2&envId=two-pointers
public class ReorderList {
    public void reorderList(ListNode head) {
        // 중간지점 찾기
        // 후반부 뒤집음
        // 합침
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;

        ListNode first = head;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
