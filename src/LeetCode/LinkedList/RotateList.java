package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=linked-list
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        // k번만큼 반복 해버리면 node 사이즈 만큼 돌아야될수도 있어서 계산
        int length = 1;
        ListNode current = head;
        while(current.next != null) {
            length++;
            current = current.next;
        }

        int size = k % length;

        if(size == 0) {
            return head;
        }

        current.next = head; // 연결

        ListNode newTail = head;
        for(int i = 0; i < length - size - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
