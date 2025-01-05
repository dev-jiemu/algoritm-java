package src.Books.CodingInterview.LinkedListAndMap.LinkedListRemoveRedundantPath;


public class RemoveRedundant {
    private final class Node {
        private int r;
        private int c;
        private Node next;

        @Override
        public String toString() {
            return " (" + r + ", " + c + ") ";
        }
    }

    private Node head;

    public void removeRedundantPath() {
        Node currentNode = head;

        while(currentNode.next != null && currentNode.next.next != null) {
            Node middleNode = currentNode.next.next;

            // 중복 확인 (수직, 수평)
            if (currentNode.c == currentNode.next.c && currentNode.c == middleNode.c) {
                currentNode.next = middleNode;
            } else if (currentNode.r == currentNode.next.r && currentNode.r == middleNode.r) {
                currentNode.next = middleNode;
            } else {
                currentNode = currentNode.next;
            }
        }
    }
}
