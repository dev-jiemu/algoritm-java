package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

import java.util.*;

// https://leetcode.com/problems/sum-of-left-leaves/?envType=problem-list-v2&envId=breadth-first-search
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Boolean> isLeftQueue = new LinkedList<>();

        nodeQueue.offer(root);
        isLeftQueue.offer(false);

        int result = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            boolean isLeft = isLeftQueue.poll();

            // 왼쪽 잎 노드만 체크
            if (current.left == null && current.right == null && isLeft) {
                result += current.val;
            }

            if (current.left != null) {
                nodeQueue.offer(current.left);
                isLeftQueue.offer(true);
            }

            if (current.right != null) {
                nodeQueue.offer(current.right);
                isLeftQueue.offer(false);
            }
        }

        return result;
    }
}
