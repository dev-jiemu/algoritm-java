package src.Books.CheetSheetWithLeetCode.TwoPointer;

public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}
