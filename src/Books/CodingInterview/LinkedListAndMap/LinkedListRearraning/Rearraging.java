package src.Books.CodingInterview.LinkedListAndMap.LinkedListRearraning;

import src.Books.CodingInterview.LinkedListAndMap.Node;

// 연결 리스트 재배열
public class Rearraging {

    public Node head;
    public Node tail;

    public void rearrage(int n) {
        Node currentNode = head;
        head = currentNode;
        tail = currentNode;

        while(currentNode != null ){
            Node nextNode = currentNode.next;

            if (currentNode.data < n) {
                currentNode.next = head;
                head = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }

            currentNode = nextNode;
        }

        tail.next = null;
    }
}
