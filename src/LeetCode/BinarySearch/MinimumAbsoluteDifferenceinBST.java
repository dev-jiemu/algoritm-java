package src.LeetCode.BinarySearch;

import src.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150
public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            result = Math.min(result, values.get(i) - values.get(i - 1));
        }

        return result;
    }

    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }
}
