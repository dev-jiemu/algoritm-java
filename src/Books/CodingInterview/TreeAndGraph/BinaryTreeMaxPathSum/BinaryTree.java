package src.Books.CodingInterview.TreeAndGraph.BinaryTreeMaxPathSum;

import src.Books.CodingInterview.TreeAndGraph.Node;

public class BinaryTree {

    /*
        4개 중에 하나가 최대 경로에 포함되어야 함
        1. 최대 경로의 유일한 노드
        2. 왼쪽 자식과 함께 최대 경로일때
        3. 오른쪽 자식과 함께 최대 경로일때
        4. 왼쪽, 오른쪽 자식과 함께 최대 경로일때
     */

    // 후위 순위
    private Node root = null;
    private int max;

    private class Node {
        private Node left;
        private Node right;

        private final int element;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, int element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum() {
        return this.maxPathSum(root);
    }

    private int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));
        max = Math.max(max, left + right + root.element);

        return Math.max(left, right) + root.element;
    }
}
