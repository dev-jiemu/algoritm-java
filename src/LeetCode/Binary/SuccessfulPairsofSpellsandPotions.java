package src.LeetCode.Binary;

import java.util.Arrays;

// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/?envType=study-plan-v2&envId=leetcode-75
public class SuccessfulPairsofSpellsandPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // 정렬하고 시작
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i]; // 올림계산

            int left = 0;
            int right = potions.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (potions[mid] >= minPotion) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = potions.length - left;
        }

        return result;
    }
}
