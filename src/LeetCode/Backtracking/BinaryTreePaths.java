package src.LeetCode.Backtracking;

import src.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/description/?envType=problem-list-v2&envId=backtracking
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        path += node.val;

        // Leaf node
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // 자식 노드들 탐색
        path += "->";
        if (node.left != null) {
            dfs(node.left, path, result);
        }
        if (node.right != null) {
            dfs(node.right, path, result);
        }
    }
}
