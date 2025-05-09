package src.LeetCode.BFS;

import src.LeetCode.BFS.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                current.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(current);
        }

        return result;
    }

    // 재귀로도 풀수 있군 ㅇㅂㅇ
    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelHelper(result, root, 0);
        return result;
    }

    private void levelHelper(List<List<Integer>> list, TreeNode node, int height) {
        if(node==null) return;
        if(height == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(height).add(node.val);
        levelHelper(list, node.left, height + 1);
        levelHelper(list, node.right, height + 1);
    }
}
