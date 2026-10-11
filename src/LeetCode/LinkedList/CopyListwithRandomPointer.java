package src.LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

// 138. Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-interview-150
public class CopyListwithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//
//        Map<Node, Node> map = new HashMap<>();
//
//        Node current = head;
//        while(current != null) {
//            map.put(current, new Node(current.val));
//            current = current.next;
//        }
//
//        current = head;
//        while(current != null) {
//            Node copyNode = map.get(current);
//            copyNode.next = map.get(current.next);
//            copyNode.random = map.get(current.random);
//            current = current.next;
//        }
//
//        return map.get(head);
//    }
    // 2026.10.11 refactoring : 공간 O(1) - 노드 끼워넣기
    /*
    원본:  A → B → C
    1단계(끼워 넣기):  A → A' → B → B' → C → C'
    2단계(random 연결): A'.random = A.random.next   (A.random이 null이면 null)
    3단계(분리):        A → B → C   /   A' → B' → C'
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while(current != null) {
            Node next = current.next;
            Node newNode = new Node(current.val);

            newNode.next = next;
            current.next = newNode;

            current = next;
        }

        // random 연결
        current = head;
        while(current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        Node copyHead = head.next;
        current = head;
        while(current != null) {
            Node copy = current.next;
            Node nextOrigin = copy.next;

            current.next = nextOrigin;
            copy.next = (nextOrigin != null) ? nextOrigin.next : null;  // 끝 체크

            current = nextOrigin;
        }

        return copyHead;
    }
}
