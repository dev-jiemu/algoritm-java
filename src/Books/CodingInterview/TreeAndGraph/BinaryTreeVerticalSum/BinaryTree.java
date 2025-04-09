package src.Books.CodingInterview.TreeAndGraph.BinaryTreeVerticalSum;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.Map;

public class BinaryTree {
    // HashMap 으로 고유한 위치로 계산
    // 왼쪽 -, 오른쪽 +
    // ex) -3, -2, -1, 0(root), 1, 2, 3
    private Node root;

    private void verticalSum(Node root, Map<Integer, Integer> map, int dist) {
        if(root == null) return;
        if (!map.containsKey(dist)) map.put(dist, 0);

        map.put(dist, map.get(dist) + (Integer) root.element); // 합계 저장

        verticalSum(root.left, map, dist - 1);
        verticalSum(root.right, map, dist + 1);
    }

    // TODO: 이중 연결 리스트로 O(n) 까지 시간 복잡도를 줄여보면? -> 이것도 왼쪽, 오른쪽 재귀로 그냥 더하면 될듯?
}
