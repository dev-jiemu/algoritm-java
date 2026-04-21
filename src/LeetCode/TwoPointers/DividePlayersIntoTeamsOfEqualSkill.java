package src.LeetCode.TwoPointers;

import java.util.Arrays;

// 2491. Divide Players Into Teams of Equal Skill
// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
public class DividePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        long result = 0;

        Arrays.sort(skill);

        int left = 0;
        int right = skill.length - 1;
        int targetSum = skill[left] + skill[right];

        while (left < right) {
            if (skill[left] + skill[right] != targetSum) {
                return -1;
            }
            result += (long) skill[left] * skill[right];
            left++;
            right--;
        }

        return result;
    }
}
