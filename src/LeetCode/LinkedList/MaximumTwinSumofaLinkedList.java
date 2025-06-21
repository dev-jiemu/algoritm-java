package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
public class MaximumTwinSumofaLinkedList {
    public int pairSum(ListNode head) {
        int result = 0;
        List<Integer> nodeList = new ArrayList<>();

        ListNode node = head;
        while(node != null) {
            nodeList.add(node.val);
            node = node.next;
        }

        int left = 0;
        int right = nodeList.size() - 1;

        while(left < right) {
            int value = nodeList.get(left) + nodeList.get(right);

            result = Math.max(result, value);

            left++;
            right--;
        }

        return result;
    }
}
