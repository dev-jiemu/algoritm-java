package src.LeetCode.Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/
public class EliminateMaximumNumberOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        float[] arrivalTimes = new float[dist.length];

        for(int i = 0; i < dist.length; i++) {
            arrivalTimes[i] = (float)dist[i] / speed[i];
        }

        Arrays.sort(arrivalTimes);

        for(int i = 0; i < arrivalTimes.length; i++) {
            if (i >= arrivalTimes[i]) {
                return i;
            }
        }

        return dist.length; // 모두 제거
    }
}
