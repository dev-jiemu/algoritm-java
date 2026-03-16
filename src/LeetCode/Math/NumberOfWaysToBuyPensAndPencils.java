package src.LeetCode.Math;

// https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/description/
public class NumberOfWaysToBuyPensAndPencils {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long result = 0;

        // 펜 개수 기준으로 순회
        for(int i = 0; i * cost1 <= total; i++) {
            int remaining = total - i * cost1;
            result += remaining / cost2 + 1; // 0도 개수로 쳐주는듯
        }

        return result;
    }
}
