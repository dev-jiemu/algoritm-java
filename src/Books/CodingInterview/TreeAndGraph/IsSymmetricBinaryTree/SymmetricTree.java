package src.Books.CodingInterview.TreeAndGraph.IsSymmetricBinaryTree;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    // 왼쪽 노드 = 오른쪽 노드 => 대칭임

    // 재귀 기반
    private boolean isSymmetricRecursive(Node leftNode, Node rightNode) {
        boolean result = false;

        if (leftNode == null && rightNode == null) result = true;

        if (leftNode != null && rightNode != null) {
            result = (leftNode.element.equals(rightNode.element)) && isSymmetricRecursive(leftNode.left, rightNode.right) && isSymmetricRecursive(leftNode.right, rightNode.left);
        }

        return result;
    }

    private Node root;

    // 반복 기반
    private boolean isSymmetricIterative() {
        if (root == null) return true;

        boolean result = false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()) {
            Node left = queue.poll();
            Node right = queue.poll();

            if (left == null && right == null) {
                result = true;
            } else if (left == null || right == null || left.element != right.element) {
                result = false;
                break;
            } else {
                queue.offer(left.left);
                queue.offer(right.right);

                queue.offer(left.right);
                queue.offer(right.left);
            }
        }

        return result;
    }
}
