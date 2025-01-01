package src.Books.CodingInterview.LinkedListAndMap.LinkedListMergeTwoSorted;

import src.Books.CodingInterview.LinkedListAndMap.Node;

// list1, list2 node data 비교해서 next node 바꿔치기 하면 될듯
public class MergeToSorted {
    private Node head;

    public void setHead(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;

        head = newNode;
    }

    public void merge(MergeToSorted mts) {
        Node list1 = head;
        Node list2 = mts.head; // 대강 기준점 잡을 아무 노드

        if (list1.data < list2.data) {
            head = list1;
        } else {
            head = list2;
            list2 = list1;
            list1 = head;
        }

        while(list1.next != null) {
            if (list1.next.data > list2.data) { // list1 이 더 크면 교체
                Node temp = list1.next;
                list1.next = list2;
                list2 = temp;
            }

            list1 = list1.next;
        }

        // list1에 대한 작업이 끝날 경우 list2 노드 맨 뒤에 추가
        list1.next = list2;
    }

    // 재귀로 풀면
    public Node mergeRecursion(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        Node resultNode;

        if (list1.data <= list2.data) {
            resultNode = list1;
            resultNode.next = mergeRecursion(list1.next, list2);
        } else {
            resultNode = list2;
            resultNode.next = mergeRecursion(list1, list2.next);
        }

        return resultNode;
    }
}
