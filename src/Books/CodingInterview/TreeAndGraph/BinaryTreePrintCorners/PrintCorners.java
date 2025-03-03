package src.Books.CodingInterview.TreeAndGraph.BinaryTreePrintCorners;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintCorners {
    // 각 단계별로 맨 왼쪽과 맨 오른쪽 출력해주면 됨!
    public Node root;
    public PrintCorners(Node root) {
        this.root = root;
    }

    public void printCorners() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int position = size;
            System.out.print("Level: " + level + ": ");
            level++;

            while(position > 0) {
                Node node = queue.poll();
                position--;

                // 양 끝 노드
                if (position == (size - 1) || position == 0) {
                    System.out.print(node.element + " ");
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                System.out.println();
            }
        }
    }
}
