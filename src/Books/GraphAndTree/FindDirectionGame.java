package src.Books.GraphAndTree;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42892
public class FindDirectionGame {

    private static class Node {
        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        private Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    // 이진트리
    // 전위, 후위 둘다 계산
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];

        // y좌표 = 계층관계를 나타냄 = 클수록 root 노드일 확률이 높음
        // x좌표 = 왼쪽이냐 오른쪽이냐를 나타냄 = 작을수록 왼쪽 노드
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // 윗부분부터 순회해야하니까 y축으로 정렬
        Arrays.sort(nodes, (left, right) -> right.y - left.y);

        Node root = constructTree(nodes);

        List<Integer> preorder = new ArrayList<>();
        pre(root, preorder);

        List<Integer> postorder = new ArrayList<>();
        post(root, postorder);

        return new int[][]{
            preorder.stream().mapToInt(Integer::intValue).toArray(),
            postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    // 순회
    private Node constructTree(Node[]nodes) {
        Node root = nodes[0]; // 정렬된거니까 0번으로 잡으면 됨

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        return root;
    }

    // 삽입
    private void insert(Node root, Node node) {
        if (node.x < root.x) { // 왼쪽에 넣음
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    private void pre(Node node, List<Integer> visits) {
        if(node != null) {
            visits.add(node.value);
            pre(node.left, visits);
            pre(node.right, visits);
        }
    }

    private void post(Node node, List<Integer> visits) {
        if(node != null) {
            post(node.left, visits);
            post(node.right, visits);
            visits.add(node.value);
        }
    }

}
