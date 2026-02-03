package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/?envType=problem-list-v2&envId=binary-tree
public class PathSumTwo {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath) {
        if (node == null) return;

        currentPath.add(node.val);

        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        }

        dfs(node.left, remainingSum - node.val, currentPath);
        dfs(node.right, remainingSum - node.val, currentPath);

        // 백트래킹
        currentPath.remove(currentPath.size() - 1);
    }
}
