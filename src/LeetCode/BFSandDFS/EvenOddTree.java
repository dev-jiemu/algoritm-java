package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        // if (root.val == 0) { return false; }

        int level = 0; // 홀수 레벨 = 모든 값이 짝수여야 함, 짝수 레벨 = 모든값이 홀수여야 함
        int prev = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // 짝수레벨인데 짝수값, 홀수레벨인데 홀수값 = false
                if ((level % 2 == 0 && current.val % 2 == 0) || (level % 2 != 0 && current.val % 2 != 0)) {
                    return false;
                }

                // 짝수레벨인데 감소이거나 홀수레벨인데 증가면 = false
                if ((level % 2 == 0 && current.val <= prev) || (level % 2 != 0 && current.val >= prev)) {
                    return false;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

                prev = current.val;
            }

            // prev = 0;
            prev = (level % 2 == 0) ? Integer.MAX_VALUE : 0;
            level++;
        }

        return true;
    }
}
