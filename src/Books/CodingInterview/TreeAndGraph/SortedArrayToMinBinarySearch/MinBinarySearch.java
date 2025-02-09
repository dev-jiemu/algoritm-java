package src.Books.CodingInterview.TreeAndGraph.SortedArrayToMinBinarySearch;

import src.Books.CodingInterview.TreeAndGraph.Node;

public class MinBinarySearch<T> {

    private int nodeCount = 0;
    private Node root = null;

    /*
        1. 배열 가운데가 트리 root 가 됨
        2. 왼쪽 하위 배열을 왼쪽에, 오른쪽 하위 배열을 오른쪽에
        3. 재귀로 반복 호출
     */
    public void minimalBst(T[] m) {
        root = minimalBst(m, 0, m.length - 1);
    }

    private Node minimalBst(T[] m, int start, int end) {

        int middle = (start + end) / 2;
        Node node = new Node(m[middle]);

        nodeCount++;

        node.left = minimalBst(m, start, middle - 1);
        node.right = minimalBst(m, middle + 1, end);

        return node;
    }

}
