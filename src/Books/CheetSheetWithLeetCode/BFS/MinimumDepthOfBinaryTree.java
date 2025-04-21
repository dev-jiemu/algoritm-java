package src.Books.CheetSheetWithLeetCode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    /**
     * Definition for a binary tree node
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 최악일때 시간복잡도 O(N)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left == null && current.right == null) return depth; // 끝부분

                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }

            depth++;
        }

        return depth;
    }

}
