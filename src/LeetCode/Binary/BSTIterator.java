package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

import java.util.*;

// 173. Binary Search Tree Iterator
// https://leetcode.com/problems/binary-search-tree-iterator/description/
class BSTIterator {
//    private final List<Integer> values = new ArrayList<>();
//    private int idx = 0;
//
//    public BSTIterator(TreeNode root) {
//        inorder(root);
//    }
//
//    private void inorder(TreeNode node) {
//        if (node == null) return;
//        inorder(node.left);
//        values.add(node.val);
//        inorder(node.right);
//    }
//
//    public int next() {
//        return values.get(idx++);
//    }
//
//    public boolean hasNext() {
//        return idx < values.size();
//    }

    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode cur = stack.pop();
        pushLeft(cur.right);

        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
