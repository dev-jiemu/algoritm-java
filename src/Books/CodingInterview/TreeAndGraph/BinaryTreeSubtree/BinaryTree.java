package src.Books.CodingInterview.TreeAndGraph.BinaryTreeSubtree;

import src.Books.CodingInterview.TreeAndGraph.Node;

public class BinaryTree {
    private Node root;

    public boolean isSubtree(BinaryTree q) {
        return isSubtree(root, q.root);
    }

    private boolean isSubtree(Node p, Node q) {
        if (!match(p, q)) { // p, q가 안 같으면 하위 왼, 오른쪽끼리 비교해봐야 함
            return (isSubtree(p.left, q) || isSubtree(p.right, q));
        }

        return true;
    }

    private boolean match(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        // 같으면 오른쪽, 왼쪽끼리 비교
        return (p.element == q.element && match(p.left, q.left) && match(p.right, q.right));
    }
}
