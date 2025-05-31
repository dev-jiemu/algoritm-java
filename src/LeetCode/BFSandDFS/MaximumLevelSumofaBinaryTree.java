package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            int nodeSum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                nodeSum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (maxSum < nodeSum) {
                maxSum = nodeSum;
                result = depth;
            }
        }

        return result;
    }
}
