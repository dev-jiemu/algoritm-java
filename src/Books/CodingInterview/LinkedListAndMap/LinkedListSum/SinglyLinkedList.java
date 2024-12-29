package src.Books.CodingInterview.LinkedListAndMap.LinkedListSum;

import src.Books.CodingInterview.LinkedListAndMap.Node;

public class SinglyLinkedList {

    private Node head;

    private Node sum(Node node1, Node node2, int carry) {
        Node resultNode = new Node();

        int value = carry;
        if (node1 != null) {
            value += node1.data;
        }

        if (node2 != null) {
            value += node2.data;
        }

        resultNode.data = value % 10;
        if(node1 != null || node2 != null) {
            Node more = sum(node1 == null ? null : node1.next, node2 == null ? null : node2.next, value >= 10 ? 1 : 0);
            resultNode.next = more;
        }

        return resultNode;
    }

    // 거꾸로 출력해야됨
    private Node reverseLinkedList(Node node) {
        Node remaining = reverseLinkedList(node.next);

        node.next.next = node;
        node.next = null;

        head = remaining;

        return remaining;
    }

    public void sum(SinglyLinkedList sll) {
        SinglyLinkedList sllResult = new SinglyLinkedList();

        Node node = sum(head, sll.head, 0);
        sllResult.head = node;

        sllResult.reverseLinkedList(sllResult.head);
        sllResult.print();
    }

    public void print() {
        System.out.println("\nResult:");

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
