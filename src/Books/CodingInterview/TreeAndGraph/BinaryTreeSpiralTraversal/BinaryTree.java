package src.Books.CodingInterview.TreeAndGraph.BinaryTreeSpiralTraversal;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.Stack;

public class BinaryTree {
    // 홀수 : 왼쪽 -> 오른쪽
    // 짝수 : 오른쪽 -> 왼쪽

    private Node root;

    // 재귀로 구현 : boolean 으로 판별
    public void spiralOrderTraversalRecursive() {
        if (root == null) {
            return;
        }

        int level = 1;
        boolean flip = false;

        while(printLevel(root, level++, flip = !flip)) {

        }
    }

    private boolean printLevel(Node root, int level, boolean flip) {
        if(root == null) {
            return false;
        }

        if (level == 1) {
            System.out.print(root.element + " ");
            return true;
        }

        if (flip) { // 왼쪽 -> 오른쪽
            boolean left = printLevel(root.left, level - 1, flip);
            boolean right = printLevel(root.right, level - 1, flip);
            return left || right;
        } else { // 오른쪽 -> 왼쪽
            boolean right = printLevel(root.right, level - 1, flip);
            boolean left = printLevel(root.left, level - 1, flip);
            return right || left;
        }
    }

    // 반복으로 구현
    private void printSpiralTwoStacks(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> rl = new Stack<>(); // 오른쪽에서 왼쪽
        Stack<Node> lr = new Stack<>();

        rl.push(node);

        // 노드가 없을때까지 출력함
        while(!rl.empty() || !rl.empty()) {
            while(!rl.empty()) {
                Node temp = rl.peek();
                rl.pop();

                System.out.println(temp.element + " ");

                if (temp.right != null) {
                    lr.push(temp.right);
                }

                if (temp.left != null) {
                    lr.push(temp.left);
                }
            }

            while(!lr.empty()) {
                Node temp = lr.peek();
                lr.pop();

                System.out.println(temp.element + " ");

                if(temp.left != null) {
                    rl.push(temp.left);
                }

                if (temp.right != null) {
                    rl.push(temp.right);
                }
            }
        }
    }
}
