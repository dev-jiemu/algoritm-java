package src.Books.CodingInterview.TreeAndGraph.BinarySearchTreeDuplicates;

// 중복을 허용하는 이진탐색 트리 만들기
public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        private T element;
        private int count; // 중복안된 노드 생성하면 1임
        private Node left;
        private Node right;

        public Node(T element, int count, Node left, Node right) {
            this.element = element;
            this.count = count;
            this.left = left;
            this.right = right;
        }
    }

    private Node root = null;

    public boolean insert(T element) {
        root = insert(root, element);

        return true;
    }

    private Node insert(Node current, T element) {
        if (element.compareTo(current.element) == 0) {
            current.count++;
            return current;
        }

        if (element.compareTo(current.element) < 0) {
            current.left = insert(current.left, element);
        } else {
            current.right = insert(current.right, element);
        }

        return current;
    }

    private Node delete(Node node, T element) {
        if (element.compareTo(node.element) < 0) {
            node.left = delete(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = delete(node.right, element);
        }

        if (element.compareTo(node.element) == 0) {
            if (node.count > 0) {
                node.count--;
                return node;
            }

            if (node.right == null) {
                Node left = node.left;
                node = null;

                return left;
            } else if (node.left == null) {
                Node right = node.right;
                node = null;

                return right;
            } else {
                Node leftmost = findLeftmostNode(node.right);

                node.element = leftmost.element;
                node.right = delete(node.right, node.element);
            }
        }

        return node;
    }

    private Node findLeftmostNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // TODO: 해시 테이블로 중복구조 구현해보기

}
