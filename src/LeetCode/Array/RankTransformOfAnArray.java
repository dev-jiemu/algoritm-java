package src.LeetCode.Array;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/rank-transform-of-an-array/description/
public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int rank = 1;
        for(int i = 0; i < sorted.length; i++) {
            if(!hashMap.containsKey(sorted[i])) {
                hashMap.put(sorted[i], rank);
                rank++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            result[i] = hashMap.get(arr[i]);
        }

        return result;
    }
}
