package src.LeetCode.BFSandDFS;

import src.LeetCode.BFSandDFS.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class MaximumDepthofBinaryTree {
    // 1. queue로 풀기
    public int maxDepth(TreeNode root) {
        int result = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // size 만큼 돌려야함 : depth check
            result++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return result;
    }

    // 2. 재귀로 풀기
    public int maxDepthRecursion(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepthRecursion(root.left), maxDepthRecursion(root.right));
    }
}
