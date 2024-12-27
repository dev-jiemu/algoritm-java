package src.Books.CodingInterview.LinkedListAndMap.LinkedListNthToLastNode;

import src.Books.CodingInterview.LinkedListAndMap.Node;

public class NthToLastNode {

    private Node head;
    private Node tail;
    private int size;

    public int nThToLastIterative(int n) {
        Node firstRunner = head;
        Node secondRunner = head;

        for (int i = 0; i < n; i++) {
//            if (firstRunner == null) {
//                throw new IllegalArgumentException("The given n index is out of bounds");
//            }

            firstRunner = firstRunner.next; // n 만큼 firstRunner 조정
        }

        while (firstRunner != null) { // 순회노드 1이 null 이면 순회노드 2가 n번째 뒤에 있는 노드인거임
            firstRunner = firstRunner.next;
            secondRunner = secondRunner.next;
        }

        return secondRunner.data;
    }
}
