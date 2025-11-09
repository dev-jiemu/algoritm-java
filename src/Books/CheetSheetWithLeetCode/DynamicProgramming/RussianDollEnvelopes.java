package src.Books.CheetSheetWithLeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/russian-doll-envelopes/description/
public class RussianDollEnvelopes {
    // 최장 증가 부분수열의 변형문제 ㅇㅂㅇ
    public int maxEnvelopes(int[][] envelopes) {
        // 너비를 오름차순으로 정렬 + 두번째는 내림차순
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    // 0번째 열 기준 오름차순
                    return a[0] - b[0];
                } else {
                    // 0번째 열 값이 같으면 1번째 열 기준 내림차순
                    return b[1] - a[1];
                }
            }
        });

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length;i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    // 점수가 낮은 카드만 높거나 같은 카두 위에 올릴수 있음
    private int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 카드 더미 수 초기화
        int piles = 0;

        for(int i = 0; i < nums.length; i++) {
            int poker = nums[i];

            int left = 0;
            int right = piles;

            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == piles) piles++;
            top[left] = poker;
        }
        
        return piles;
    }
}
