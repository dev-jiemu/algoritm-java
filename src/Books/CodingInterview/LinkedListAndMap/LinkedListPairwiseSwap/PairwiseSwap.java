package src.Books.CodingInterview.LinkedListAndMap.LinkedListPairwiseSwap;

import src.Books.CodingInterview.LinkedListAndMap.Node;

public class PairwiseSwap {
    // node1 = node2
    // node2 = node3
    // 을 가리키게 해야 서로 swap 됨
    public Node head;
    public Node tail;

    public void swap() {
        Node currentNode = head;
        Node prevPair = null;

        while(currentNode != null && currentNode.next != null) {
            Node node1 = currentNode;
            Node node2 = currentNode.next;
            Node node3 = currentNode.next.next;

            Node auxNode = node1;
            node1 = node2;
            node2 = auxNode;

            node1.next = node2;
            node2.next = node3;

            if(prevPair == null) { // 첫번째 교체일 경우 머리 노드 설정
                head = node1;
            } else {
                prevPair.next = node1;
            }

            if (currentNode.next == null) {
                tail = currentNode;
            }

            prevPair = node2;
            currentNode = node3;
        }
    }
}
