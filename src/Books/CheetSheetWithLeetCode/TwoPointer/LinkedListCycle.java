package src.Books.CheetSheetWithLeetCode.TwoPointer;

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


