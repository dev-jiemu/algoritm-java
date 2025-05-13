package src.LeetCode.PrefixSum;

// https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
public class FindtheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int result = 0; // highest

        int load = 0;
        for (int i = 0; i < gain.length; i++) {
            load += gain[i];
            result = Math.max(result, load);
        }

        return result;
    }
}
