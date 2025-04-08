package src.Books.CodingInterview.TreeAndGraph.BinarySearchTreeSum;

import src.Books.CodingInterview.TreeAndGraph.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    // 중위순위 :: HashSet
    public boolean findPairSumHashing(int sum) {
        if (sum <= 0) return false;
        return findPairSumHashing(root, sum, new HashSet());
    }

    private boolean findPairSumHashing(Node node, int sum, Set<Integer> set) {
        if (node == null) return false;

        if (findPairSumHashing(node.left, sum, set)) return true;

        if (set.contains(sum - (Integer) node.element)) {
            return true;
        } else {
            set.add((Integer) node.element);
        }

        return findPairSumHashing(node.right, sum, set);
    }

    // n의 왼쪽 후손 <= n < n의 오른쪽 후손을 활용한 풀이법
    // 최소값+최대값 < 합계이면 최소값, 그 반대면 최대값으로 이동함
    public boolean findPairSumTwoStacks(int sum) {
        if (sum <= 0 || root == null) return false;
        return findPairSumTwoStacks(root, sum);
    }

    private boolean findPairSumTwoStacks(Node node, int sum) {
        Stack<Node> fio = new Stack<>(); // 정방향 중위 순회
        Stack<Node> rio = new Stack<>(); // 역방향 중위 순회

        Node minNode = node;
        Node maxNode = node;

        while(!fio.isEmpty() || !rio.isEmpty() || minNode != null || maxNode != null) {
            if (minNode != null || maxNode != null) {
                if (minNode != null) {
                    fio.push(minNode);
                    minNode = minNode.left;
                }

                if (maxNode != null) {
                    rio.push(maxNode);
                    maxNode = maxNode.right;
                }
            } else {
                int element1 = (Integer) fio.peek().element;
                int element2 = (Integer) rio.peek().element;

                if (fio.peek() == rio.peek()) break;

                if ((element1 + element2) == sum) return true;

                if ((element1 + element2) < sum) {
                    minNode = fio.pop();
                    minNode = minNode.right;
                } else {
                    maxNode = rio.pop();
                    maxNode = maxNode.left;
                }
            }
        }

        return false;
    }
}
