package src.LeetCode.Stack;

import src.LeetCode.common.ListNode;

import java.util.Stack;

// https://leetcode.com/problems/palindrome-linked-list/description/?envType=problem-list-v2&envId=stack
public class PalindromeLinkedList {
    // 절반만 봐도 될듯
    public boolean isPalindrome(ListNode head) {
        // Two Pointer
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // 홀수 길이 조정
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
