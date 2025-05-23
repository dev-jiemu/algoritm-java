package src.LeetCode.BFSandDFS;

import src.LeetCode.BFSandDFS.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

    // 같은 레벨의 노드들은 연결됨
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // size - 1 만큼 next 가 있음
                // 문제에서 완전이진트리라고 명시해서 이렇게 처리해도 됨 ㅇㅇ
                if (i < size - 1) {
                    current.next = queue.peek();
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return root;
    }

    // queue 안쓰고 이렇게 하는 방법도 있었네.....
    public Node connectMost(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;
        while (root.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }

}
