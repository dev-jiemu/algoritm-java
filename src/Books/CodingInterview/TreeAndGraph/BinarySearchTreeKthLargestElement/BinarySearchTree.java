package src.Books.CodingInterview.TreeAndGraph.BinarySearchTreeKthLargestElement;

import src.Books.CodingInterview.TreeAndGraph.Node;

public class BinarySearchTree {

    // 역중위 순회 풀이법
    public void kthLargest(int k) {
        this.kthLargest(root, k);
    }

    private Node root;
    private int c; // 방문한 노드의 개수

    private void kthLargest(Node root, int k) {
        kthLargest(root.right, k);
        c++;
        
        if (c == k) { // 찾음
            System.out.println("result : " + root.element);
        }

        kthLargest(root.left, k);
    }
}
