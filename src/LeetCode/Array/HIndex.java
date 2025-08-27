package src.LeetCode.Array;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if(citations[i] >= h) {
                return h;
            }
        }


        return 0;
    }
}
