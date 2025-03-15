package src.Books.CodingInterview.TreeAndGraph.BinaryTreePrintDiagonal;
import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.*;

public class PrintDiagonal<T> {
    private Node root = null;

    // 1. 재귀 with 해싱으로 풀기
    // 시간복잡도 O(nlogn), 공간복잡도 O(n)
    public void printDiagonalRecursive() {
        Map<Integer, List<T>> map = new HashMap<>();

        printDiagonal(root, 0, map);

        for(int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }

    private void printDiagonal(Node node, int diagonal, Map<Integer, List<T>> map) {
        if(node == null) {
            return;
        }

        if (!map.containsKey(node)) {
            map.put(diagonal, new ArrayList<>());
        }

        map.get(diagonal).add((T) node.element);

        printDiagonal(node.left, diagonal + 1, map); // 대각선 1증가 + 왼쪽 하위트리
        printDiagonal(node.right, diagonal, map); // 오른쪽 하위트리
    }

    // 2. 반복적으로 풀어보기 : 레벨 순회 + queue
    // 시간복잡도 O(n), 공간복잡도 O(n)
    /*
        - 루트, 오른쪽 자식 큐에 다 넣음
        - 대기열이 비여있지 않은 동안
            - 노드 큐에서 꺼냄(A)
            - A 출력
            - 노드 A에 왼쪽 자식이 있으면 큐에 넣음
                - B의 오른쪽 자식을 큐에 넣음
     */
    public void printDiagonalIterative() {
        Queue<Node> queue = new ArrayDeque<>();

        // 대각선의 끝
        Node dummy = new Node(null);

        while(root != null) {
            queue.add(root);
            root = root.right; // 오른쪽 노드 넣음
        }

        queue.add(dummy); // 끝 표시

        while(queue.size() != 1) {
            Node front = queue.poll();

            if(front != dummy) {
                System.out.println(front.element + " ");

                Node node = front.left;
                while(node != null) {
                    queue.add(node);
                    node = node.right;
                }
            } else {
                queue.add(dummy);
                System.out.println();
            }
        }

    }

}
