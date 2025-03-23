package src.Books.CodingInterview.TreeAndGraph.BinaryTreeRightView;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    private void printRightViewIterative(Node root) {
        if (root == null) { return; }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Node currentNode;
        while(!queue.isEmpty()) {
            int size = queue.size();

            int i = 0;
            while(i < size) {
                i++;
                currentNode = queue.poll();

                if (i == size) {
                    System.out.print(currentNode.element + " ");
                }

                if (currentNode.left != null) { // 왼쪽 노드 있으면 큐에 추가
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) { // 오른쪽 노드도 있으면 큐에 추가
                    queue.add(currentNode.right);
                }
            }
        }
    }
}
