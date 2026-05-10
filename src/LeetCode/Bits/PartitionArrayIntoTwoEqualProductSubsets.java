package src.LeetCode.Bits;

// 3566. Partition Array into Two Equal Product Subsets
// https://leetcode.com/problems/partition-array-into-two-equal-product-subsets/
public class PartitionArrayIntoTwoEqualProductSubsets {
    public boolean checkEqualPartitions(int[] nums, long target) {
        // 브루트포스인데 비트마스킹 방식으로
        int n = nums.length;

        // 모든 원소의 곱이 target ^ 2 보다 크면 애당초 불가능함
        long totalProduct = 1;
        for (int num : nums) {
            totalProduct *= num;
            if (totalProduct > target * target) {
                return false;
            }
        }

        // 달라도 불가능임
        if (totalProduct != target * target) {
            return false;
        }

        /**
         * 해당 마스크 부분 햇갈려서 클로드한테 이것저것 물어봄
         *
         * n=3개 원소 → 각각 "선택" 또는 "미선택" → 2^3 = 8가지 경우
         *
         * mask   이진수    각 원소의 선택 여부
         *               nums[2] nums[1] nums[0]
         * 0      000      X       X       X
         * 1      001      X       X       O
         * 2      010      X       O       X
         * 3      011      X       O       O
         * 4      100      O       X       X
         * 5      101      O       X       O
         * 6      110      O       O       X
         * 7      111      O       O       O
         *        ↑↑↑
         *        각 비트 = 각 원소의 on/off 스위치!
         *
         * 이렇게 보니 알겠군 ㅇㅂㅇ ㅋㅋ
         */

        for(int mask = 1; mask < (1 << n) - 1; mask++) {
            long product = 1;
            for(int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    product *= nums[i];
                    if (product > target) break; // 조기 종료
                }
            }
            if (product == target) {
                return true;
            }
        }

        return false;
    }
}

// 아니면 백트래킹으로 풀어도 됨 ㅇㅂㅇ
