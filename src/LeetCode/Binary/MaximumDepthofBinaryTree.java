package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-interview-150
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        int depth = 0;

        if (root == null) { return depth; }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

            depth++;
        }

        return depth;
    }
}
