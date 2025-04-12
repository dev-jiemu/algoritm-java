package src.Books.CodingInterview.TreeAndGraph.BinaryTreeVerticalSum;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.Map;

public class BinaryTree {
    // HashMap 으로 고유한 위치로 계산
    // 왼쪽 -, 오른쪽 +
    // ex) -3, -2, -1, 0(root), 1, 2, 3
    private Node root;

    private void verticalSum(Node root, Map<Integer, Integer> map, int dist) {
        if (root == null) return;
        if (!map.containsKey(dist)) map.put(dist, 0);

        map.put(dist, map.get(dist) + (Integer) root.element); // 합계 저장

        verticalSum(root.left, map, dist - 1);
        verticalSum(root.right, map, dist + 1);
    }

    // 이중 연결 리스트(DLL)
    class DLLNode {
        int sum;
        DLLNode prev, next;

        public DLLNode(int sum) {
            this.sum = sum;
        }
    }

    public void verticalSumDLL(Node root) {
        DLLNode dllNode = new DLLNode(0);
        verticalSumDLL(root, dllNode);
    }

    private void verticalSumDLL(Node root, DLLNode dllNode) {
        if (root == null) return;

        dllNode.sum += (Integer) root.element;

        // 재귀로 쭉 계산

        if (root.left != null) {
            if (dllNode.prev == null) dllNode.prev = new DLLNode(0);
            dllNode.prev.next = dllNode;
            verticalSumDLL(root.left, dllNode.prev);
        }

        if (root.right != null) {
            if (dllNode.next == null) dllNode.next = new DLLNode(0);
            dllNode.next.prev = dllNode;
            verticalSumDLL(root.right, dllNode.next);
        }
    }

}
