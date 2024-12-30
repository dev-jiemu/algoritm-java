package src.Books.CodingInterview.LinkedListAndMap.LinkedListtIntersection;

import src.Books.CodingInterview.LinkedListAndMap.Node;

public class Intersection {
    // node.1.next === node.2.next 인 경우 = 교차

    public Node head;
    public Node tail;

    public int intersection(int size1, int size2) {

        Node currentNode1 = head;
        Node currentNode2 = tail;

        // 위치조정
        if (size1 > size2) {
            for (int i = 0; i < (size1 - size2); i++) {
                currentNode1 = currentNode1.next;
            }
        } else {
            for(int i = 0; i < (size2 - size1); i++) {
                currentNode2 = currentNode2.next;
            }
        }

        while(currentNode1 != null && currentNode2 != null) {
            if (currentNode1 == currentNode2) { // 객체 참조로 비교 가능
                return currentNode1.data;
            }

            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }

        return -1;
    }
}
