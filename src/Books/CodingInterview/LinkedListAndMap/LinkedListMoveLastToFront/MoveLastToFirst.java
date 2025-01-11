package src.Books.CodingInterview.LinkedListAndMap.LinkedListMoveLastToFront;

import src.Books.CodingInterview.LinkedListAndMap.Node;

public class MoveLastToFirst {
    public Node head;

    public void moveLastToFront() {
        Node currentNode = head;

        while(currentNode.next.next != null) {
            currentNode = currentNode.next;
            Node nextNode = currentNode.next;

            currentNode.next = null; // 꼬리노드 처리

            nextNode.next = head;
            head = nextNode;
        }
    }

    public void moveLastToFrontTwo() {
        Node currentNode = head;

        while(currentNode.next.next != null) {
            currentNode = currentNode.next; // 뒤에서 두번째까지로 쭉 이동
        }

        currentNode.next.next = head; // 원형리스트 처리
        head = currentNode.next;

        currentNode.next = null;
    }
}
