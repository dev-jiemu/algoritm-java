package src.LeetCode.Hash;

// 2526. Find Consecutive Integers from a Data Stream
// https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/description/
public class FindConsecutiveIntegersFromADataStream {
    class DataStream {
        private int value;
        private int k;
        // hashmap 으로 value 들어오는거 다 세려고 했는데, 마지막에 들어온것만 체크해도 된다네? ㅇㅂㅇ feat. claude
        private int streak;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
            this.streak = 0;
        }

        public boolean consec(int num) {
            if (num == value) {
                streak++;
            } else {
                streak = 0;
            }
            return streak >= k;
        }
    }
}
