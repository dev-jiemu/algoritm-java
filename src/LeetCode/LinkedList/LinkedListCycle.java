package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-interview-150
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast, slow;

        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 순환
            if(fast == slow) return true;
        }

        return false;
    }
}
