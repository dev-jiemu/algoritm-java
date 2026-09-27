package src.LeetCode.Array;

// 1674. Minimum Moves to Make Array Complementary
// https://leetcode.com/problems/minimum-moves-to-make-array-complementary/
public class MinimumMovesToMakeArrayComplementary {
    // 일단 O(n^2) 로 단순하게 풀어보기 : 이거 문제 제약조건때문에 타임아웃남
//    public int minMoves(int[] nums, int limit) {
//        int result = Integer.MAX_VALUE; // 아주 큰값
//        int n = nums.length;
//
//        for (int i = 2; i <= 2 * limit; i++) {
//            int cost = 0;
//            for (int j = 0; j < n / 2; j++) {
//                int a = nums[j];
//                int b = nums[n - 1 - j];
//
//                if (a + b == i) {
//                    // a + b = i 성립하면 변할게 없어서 건너뜀
//                } else if ((1 <= i - b && i - b <= limit) || (1 <= i - a && i - a <= limit)) { // 둘중 하나 바꿔야 하면
//                    cost += 1;
//                } else { // 둘다 바꿔야하면
//                    cost += 2;
//                }
//            }
//
//            result = Math.min(result, cost);
//        }
//
//        return result;
//    }

    // 최적화 : 변화점만 배열 하나에 모아서 생각해보기
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        int[] change = new int[2 * limit + 2];

        // change 배열 만들기
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b);
            int high = Math.max(a, b);

            // 처음은 2로 시작
            change[2]              += 2;
            change[low + 1]         -= 1;  // 여기부터 1번으로 줄어듦
            change[a + b]          -= 1;
            change[a + b + 1]      += 1;  // 다음 칸부터 다시 1번
            change[high + limit + 1] += 1;  // 여기부터 다시 2번
        }

        int current = 0;
        for (int T = 2; T <= 2 * limit; T++) {
            current += change[T];
            result = Math.min(result, current);
        }

        return result;
    }
}
