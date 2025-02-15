package src.Books.CodingInterview.TreeAndGraph.BinaryTreeBalanced;

import src.Books.CodingInterview.TreeAndGraph.Node;

// 두 하위 트리 높이 차이가 1 이하면 true
public class Balanced {

    public Node root;

    public boolean isBalanced1() {
        return isBalanced(root);
    }

    public boolean isBalanced2() {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private boolean isBalanced(Node root) {
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // 얘는 높이만 계산함 O(nlogn)
    private int height(Node root) {
        return Math.max(height(root.left), height(root.right) + 1);
    }

    private int checkHeight(Node root) {
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
