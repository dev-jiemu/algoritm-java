package src.LeetCode.Binary;

import src.LeetCode.common.TreeNode;

public class MaximumSumBSTInBinaryTree {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    private int[] postorder(TreeNode node) {
        if (node == null) {
            // isBST, max, min, sum result
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = postorder(node.left);
        int[] right = postorder(node.right);

        // 왼쪽 max < 현재값
        // 오른쪽 min > 현재값
        if (left[0] == 1 && right[0] == 1 && node.val > left[2] && node.val < right[1]) {
            int sum = left[3] + right[3] + node.val;
            maxSum = Math.max(maxSum, sum); // max 값 저장

            // 자식이 없는 경우
            int minVal = (left[1] == Integer.MAX_VALUE) ? node.val : left[1];
            int maxVal = (right[2] == Integer.MIN_VALUE) ? node.val : right[2];
            return new int[]{1, minVal, maxVal, sum};
        }

        return new int[]{0, 0, 0, 0};
    }
}
