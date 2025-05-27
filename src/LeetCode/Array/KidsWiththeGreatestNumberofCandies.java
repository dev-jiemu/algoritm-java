package src.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
public class KidsWiththeGreatestNumberofCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        // max size check
        int maxCandy = 0;
        for (int candy : candies) {
            if (maxCandy < candy) {
                maxCandy = candy;
            }
        }

        for (int i = 0; i < candies.length; i++) {
            int current = candies[i] + extraCandies;

            if (maxCandy <= current) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
