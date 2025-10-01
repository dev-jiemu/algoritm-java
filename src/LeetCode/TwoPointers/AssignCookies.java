package src.LeetCode.TwoPointers;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/?envType=problem-list-v2&envId=greedy
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // 배열 정렬
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;

        int i = 0; // 아이
        int j = 0; // 쿠키

        while (i < g.length && j < s.length) {
            if(g[i] <= s[j]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return result;
    }
}
