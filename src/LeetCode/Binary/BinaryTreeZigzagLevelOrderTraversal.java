package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 지그재그 패턴: 왼쪽 -> 오른쪽, 오른쪽 -> 왼쪽 반복
        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> current = new ArrayList<>();

            for(int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                   current.add(node.val);
                } else {
                    current.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(current);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
