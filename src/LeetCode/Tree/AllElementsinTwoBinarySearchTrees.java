package src.LeetCode.Tree;

import src.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 1305. All Elements in Two Binary Search Trees
// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
public class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        return merge(list1, list2);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        // 남은거 처리
        while (i < list1.size()) {
            result.add(list1.get(i++));
        }

        while (j < list2.size()) {
            result.add(list2.get(j++));
        }

        return result;
    }
}
