package src.Books.CodingInterview.TreeAndGraph.BinarySearchTreeSuccessor;

public class SearchTree {
    // n 노드의 오른쪽 하위 트리가 후속노드 s
    // 만약, n 노드가 오른쪽 하위트리가 없고 n 의 부모 노드가 왼쪽 자식이면 = n의 부모 = s
    // n 노드에 오른쪽 하위트리가 없고 n이 부모의 오른쪽 자식이면 = n의 왼쪽 자식이 나올때까지 찾음
    private class Node {
        private final int element;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private Node root = null;

    private Node inOrderSuccessor(Node node) {
        if (node.right != null) {
            return findLeftmostNode(node.right);
        }

        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }

    private Node findLeftmostNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
