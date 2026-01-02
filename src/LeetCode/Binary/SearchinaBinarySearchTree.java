package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

// https://leetcode.com/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;

        while(current != null) {
            if (current.val == val) {
                return current;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return current;
    }
}
