package src.Books.CodingInterview.LinkedListAndMap.DoublyLinkedListReverse;

import src.Books.CodingInterview.LinkedListAndMap.Node;

public class DoublyLinkedListReverse {
    public Node head;

    public void reverse() {
        Node currentNode = head;
        Node prevNode = null;

        while(currentNode != null) {
            Node prev = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = prev;

            prevNode = currentNode;

            currentNode = currentNode.prev;
        }
        
        // 머리 노드가 마지막 노드 가리키게 변경
        if (prevNode != null) {
            head = prevNode;
        }
    }
}
