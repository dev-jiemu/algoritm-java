package src.Books.CodingInterview.TreeAndGraph.BinaryTreeisBST;
import src.Books.CodingInterview.TreeAndGraph.Node;

// minElement, maxElement 각자 비교
// root 노드는 하위 왼쪽 노드보다 크고, 오른쪽 노드보단 작아야 함을 반드시 만족해야함 (left < root < right)
public class BinaryTree<T> {
    public final Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean isBinarySearchTree() {
        return this.isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node node, T minElement, T maxElement) {
        if (node == null) {
            return true;
        }

        // root 노드가 min 노드보다 작거나 max 노드보다 크면 완전 이진 탐색 트리 아님
        if ((minElement != null && node.element.compareTo(minElement) <= 0) || (maxElement != null && node.element.compareTo(maxElement) > 0)) {
            return false;
        }

        // 하위 노드에 대해서 동일하게 비교
        if (!isBinarySearchTree(node.left, minElement, (T) node.element) || !isBinarySearchTree(node.right, (T) node.element, maxElement)) {
            return false;
        }

        return true;
    }
}
