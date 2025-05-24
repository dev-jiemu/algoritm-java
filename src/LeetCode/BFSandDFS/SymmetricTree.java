package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    // BFS 로 풀면
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();

        left.offer(root.left);
        right.offer(root.right);

        while(!left.isEmpty() && !right.isEmpty()) {
            TreeNode currentLeft = left.poll();
            TreeNode currentRight = right.poll();

            // 둘다 같으면 true 로 쳐야하나? = ㅇㅇ
            if (currentLeft == null && currentRight == null) {
                continue;
            }

            if (currentLeft == null || currentRight == null) {
                return false;
            }

            if (currentLeft.val != currentRight.val) {
                return false;
            }

            left.offer(currentLeft.left);
            left.offer(currentLeft.right);
            right.offer(currentRight.right);
            right.offer(currentRight.left);
        }

        return left.isEmpty() && right.isEmpty();
    }


    // 재귀로 풀수도 있음!
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMirror(t1.left, t1.right) && isMirror(t1.right, t2.left);
    }
}
