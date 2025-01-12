package src.Books.CodingInterview.LinkedListAndMap.ReverseLinkedListInGroups;

import src.Books.CodingInterview.LinkedListAndMap.Node;

// k를 기준으로 역순으로 묶음
public class ReverseList {
    public Node head;

    private Node reverseInKGroups(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int counter = 0;

        while(current != null && counter < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            counter++;
        }

        if(next != null) {
            head.next = reverseInKGroups(next, k);
        }

        return prev;
    }
}
