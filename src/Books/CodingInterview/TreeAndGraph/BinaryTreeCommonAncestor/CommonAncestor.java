package src.Books.CodingInterview.TreeAndGraph.BinaryTreeCommonAncestor;

public class CommonAncestor<T> {
    // 하위 트리가 n1을 포함, n2 포함 안하면 n1 반환
    // 하위 트리가 n2를 포함하고 n1 포함 안하면 n2 반환
    // 둘다 없으면 null

    private Node root = null;

    private class Node {
        private Node left;
        private Node right;

        private final T element;

        public Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    
    // insert 생략

    private Node findNode(T element, Node node) {
        if (node != null) {
            if (node.element.equals(element)) {
                return node;
            } else {
                Node foundNode = findNode(element, node.left);
                if (foundNode == null) {
                    foundNode = findNode(element, node.right);
                }
                return foundNode;
            }
        } else {
            return null;
        }
    }
    
    public T commonAncestor(T e1, T e2) {
        Node n1 = findNode(e1, root);
        Node n2 = findNode(e2, root);

        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Both nodes must be present in the tree");
        }

        return commonAncestor(root, n1, n2).element;
    }

    private Node commonAncestor(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }

        if (root == n1 && root == n2) {
            return root;
        }

        Node left = commonAncestor(root.left, n1, n2);
        if (left != null && left != n1 && left != n2) {
            return left;
        }

        Node right = commonAncestor(root.right, n1, n2);
        if (right != null && right != n1 && right != n2) {
            return right;
        }

        if (left != null && right != null) { // 서로 다른 하위트리에 있음
            return root;
        } else if (root == n1 || root == n2) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

}
