package src.LeetCode.Backtracking;

import src.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/description/?envType=problem-list-v2&envId=backtracking
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;

        List<Integer> path = new ArrayList<>();
        dfsWithList(root, path, result);

        return result;
    }

    private void dfsWithList(TreeNode node, List<Integer> path, List<String> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < path.size(); i++) {
                if (i > 0) sb.append("->");
                sb.append(path.get(i));
            }
            result.add(sb.toString());
        } else {
            dfsWithList(node.left, path, result);
            dfsWithList(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }
}
