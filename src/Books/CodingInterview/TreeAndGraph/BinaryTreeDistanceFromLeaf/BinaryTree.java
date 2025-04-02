package src.Books.CodingInterview.TreeAndGraph.BinaryTreeDistanceFromLeaf;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.List;
import java.util.Set;

public class BinaryTree {
    // 단말 노드에서 K만큼 떨어진 노드 -> 단말 노드 위의 k번째 노드
    // => 전위 순위로 계산
    // 경로가 겹칠수 있으므로 중복제거도 고려해야 함

    private Node root;

    private void leafDistance(Node node, List<Node> pathToLeaf, Set<Node> nodesAtDist, int dist) {
        if (node == null) { return; }

        if (isLeaf(node) && pathToLeaf.size() >= dist) {
            nodesAtDist.add(pathToLeaf.get(pathToLeaf.size() - dist));

            return;
        }

        pathToLeaf.add(node);

        leafDistance(node.left, pathToLeaf, nodesAtDist, dist);
        leafDistance(node.right, pathToLeaf, nodesAtDist, dist);

        pathToLeaf.remove(node);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
