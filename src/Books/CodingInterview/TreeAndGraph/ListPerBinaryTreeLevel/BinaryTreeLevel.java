package src.Books.CodingInterview.TreeAndGraph.ListPerBinaryTreeLevel;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevel<T> {
    private Node root = null;

    private class Node {
        private Node left;
        private Node right;

        private final T element;

        public Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, T element) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<T>> fetchAllLevels() {
        List<List<T>> allLevels = new ArrayList<>();

        Queue<Node> currentLevelOfNodes = new ArrayDeque<>();
        List<T> currentLevelOfElements = new ArrayList<>();

        currentLevelOfNodes.add(root);
        currentLevelOfElements.add(root.element);

        while(!currentLevelOfNodes.isEmpty()) {
            Queue<Node> previousLevelOfNodes = currentLevelOfNodes;

            allLevels.add(currentLevelOfElements);

            currentLevelOfNodes = new ArrayDeque<>();
            currentLevelOfElements = new ArrayList<>();

            for (Node parent : previousLevelOfNodes) {
                if (parent.left != null) {
                    currentLevelOfNodes.add(parent.left);
                    currentLevelOfElements.add(parent.left.element);
                }

                if (parent.right != null) {
                    currentLevelOfNodes.add(parent.right);
                    currentLevelOfElements.add(parent.right.element);
                }
            }
        }

        return allLevels;
    }
}
