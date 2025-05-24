package src.LeetCode.BFSandDFS;

import src.LeetCode.common.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int leaf1 = getNextLeaf(stack1);
            int leaf2 = getNextLeaf(stack2);

            if (leaf1 != leaf2) {
                return false;
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int getNextLeaf(Stack<TreeNode> stack) {
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left == null && node.right == null) {
                return node.val;
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return -1;
    }
}
