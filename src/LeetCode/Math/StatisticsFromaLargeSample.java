package src.LeetCode.Math;

// 1093. Statistics from a Large Sample
// https://leetcode.com/problems/statistics-from-a-large-sample/
public class StatisticsFromaLargeSample {
    public double[] sampleStats(int[] count) {
        double[] result = new double[5];

        result[0] = Double.MAX_VALUE;
        result[1] = Double.MIN_VALUE;

        int total = 0;
        int cumulative = 0;
        double median = 0;

        for(int c : count) {
            total += c;
        }

        // 홀수면 중앙값 하나가 됨 ㅇㅇ
        int left  = (total % 2 == 0) ? total / 2 : (total + 1) / 2;
        int right = (total % 2 == 0) ? total / 2 + 1 : (total + 1) / 2;

        int leftVal = 0;
        int rightVal = 0;

        int maxCount = 0;
        boolean leftFound = false;
        boolean rightFound = false;

        for (int i = 0; i < 256; i++) {
            int current = count[i];
            if (current == 0) {
                continue;
            }
            result[0] = Math.min(result[0], i);
            result[1] = Math.max(result[1], i);
            result[2] += (long) i * current;

            cumulative += count[i];

            if (!leftFound && cumulative >= left)  {
                leftVal = i;
                leftFound = true;
            }
            if (!rightFound && cumulative >= right) {
                rightVal = i;
                rightFound = true;
            }

            if (current > maxCount) {
                maxCount = current;
                result[4] = i;
            }
        }

        result[2] = result[2] / total;
        result[3] = (leftVal + rightVal) / 2.0;

        return result;
    }
}
