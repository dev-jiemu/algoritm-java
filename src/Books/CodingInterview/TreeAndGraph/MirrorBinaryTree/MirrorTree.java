package src.Books.CodingInterview.TreeAndGraph.MirrorBinaryTree;

import src.Books.CodingInterview.TreeAndGraph.Node;

public class MirrorTree {
    // 좌우 반전 트리 = 수평으로 뒤집음
    // 뒤집으면서 트리를 새로 만들어서 리턴할지, 기존 트리 자체를 뒤집을지 생각해봐야 함

    private Node root;

    // 재귀로 구성 : 트리 객체 자체를 새로 만듬
    private Node mirrorTreeInTree(Node root) {
        if (root == null) { return null; }

        Node node = new Node(root.element);
        node.left = mirrorTreeInTree(root.right); // 좌우 반대로 넣어서 생성
        node.right = mirrorTreeInTree(root.left);

        return node;
    }

    // 트리 반전 : 주어진 root 트리 자체로 반전시킴
    private void mirrorTreeInPlace(Node root) {
        if (root == null) { return; }

        Node auxNode;
        mirrorTreeInPlace(root.left);
        mirrorTreeInTree(root.right);

        auxNode = root.left; // temp
        root.left = root.right;
        root.right = auxNode;
    }

}
