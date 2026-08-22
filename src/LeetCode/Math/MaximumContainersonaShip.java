package src.LeetCode.Math;

// 3492. Maximum Containers on a Ship
// https://leetcode.com/problems/maximum-containers-on-a-ship/description/
public class MaximumContainersonaShip {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}
