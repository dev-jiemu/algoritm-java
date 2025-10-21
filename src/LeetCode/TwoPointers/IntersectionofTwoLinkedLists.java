package src.LeetCode.TwoPointers;

import src.LeetCode.common.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/?envType=problem-list-v2&envId=hash-table
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // null을 만나면 상대편 헤드로 이동
        // 둘다 같거나 둘다 null이거나 할때까지 서로 교차해가면서 이동하는거임
        while(pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }
}
