package src.LeetCode.BFS;


import src.LeetCode.BFS.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    // 1. 재귀로 깔끔하게 풀기
    public boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
    }

    // 2. BFS 본질에 맞게 풀기
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.offer(p);
        queueQ.offer(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();

            // 현재 노드 값이 다르면 false
            if (nodeP.val != nodeQ.val) return false;

            // 왼쪽
            if (nodeP.left != null && nodeQ.left != null) {
                queueP.offer(nodeP.left);
                queueQ.offer(nodeQ.left);
            } else if (nodeP.left != null || nodeQ.left != null) {
                return false;
            }

            // 오른쪽
            if (nodeP.right != null && nodeQ.right != null) {
                queueP.offer(nodeP.right);
                queueQ.offer(nodeP.right);
            } else if (nodeP.right != null || nodeQ.right != null) {
                return false;
            }
        }

        return true;
    }

}
