package src.Books.CodingInterview.TreeAndGraph.BinaryTreeLandingReservation;

import java.time.Duration;
import java.time.LocalTime;

public class TreeLanding {
    private class Node {
        private Node left;
        private Node right;

        private final LocalTime element;
        private final int time;

        public Node(LocalTime element, int time) {
            this.element = element;
            this.time = time;
        }

        public Node(Node left, Node right, LocalTime element, int time) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.time = time;
        }
    }

    private Node root = null;

    public void insert(LocalTime element, int time) {
        root = insert(root, element, time);
    }

    private Node insert(Node current, LocalTime element, int time) {

        long t1 = Duration.between(current.element.plusMinutes(current.time), element).toMinutes();
        long t2 = Duration.between(current.element, element.plusMinutes(time)).toMinutes();

        if (t1 <= 0 && t2 >= 0) { // t1이 t2보다 작거나 같으면 착륙 요청 거부
            return current;
        }

        if (element.compareTo(current.element) < 0) {
            current.left = insert(current.left, element, time);
        } else {
            current.right = insert(current.right, element, time);
        }
        
        return current;
    }

}
