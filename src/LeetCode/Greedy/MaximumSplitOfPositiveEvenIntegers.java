package src.LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2178. Maximum Split of Positive Even Integers
// https://leetcode.com/problems/maximum-split-of-positive-even-integers/description/
public class MaximumSplitOfPositiveEvenIntegers {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();

        if(finalSum % 2 != 0) {
            return list;
        }

        long remain = finalSum;
        long i = 2;
        while(remain >= i) {
            list.add(i);
            remain = remain - i;
            i += 2;
        }

        // 여기서 remain 이 애매한게 남은거 처리
        if(remain > 0) {
            int last = list.size() - 1;
            list.set(last, list.get(last) + remain);
        }

        return list;
    }
}
