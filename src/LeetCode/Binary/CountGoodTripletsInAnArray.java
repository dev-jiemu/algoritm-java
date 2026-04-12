package src.LeetCode.Binary;

// 2179. Count Good Triplets in an Array
// https://leetcode.com/problems/count-good-triplets-in-an-array/
public class CountGoodTripletsInAnArray {
    // 단순하게 y를 중앙값으로 두고 왼쪽, 오른쪽 체크해서 곱하면 되긴 하는데
    // 시간복잡도가 ㄹㅇ 노답임
//    public long goodTriplets(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        long answer = 0;
//
//        int[] pos2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            pos2[nums2[i]] = i;
//        }
//
//        for (int j = 1; j < n - 1; j++) {
//            int y = nums1[j];
//
//            int left = 0;
//            for (int i = 0; i < j; i++) {
//                if (pos2[nums1[i]] < pos2[y]) left++;
//            }
//
//            int right = 0;
//            for (int k = j + 1; k < n; k++) {
//                if (pos2[nums1[k]] > pos2[y]) right++;
//            }
//
//            answer += (long) left * right;
//        }
//
//        return answer;
//    }

    // 팬윅트리
    // 인덱스 i까지의 합을 O(log n)에 구하는 배열 기반 구조
    // https://yoongrammer.tistory.com/104
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long answer = 0;

        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] bit = new int[n + 1];
        int[] left = new int[n];

        // 왼쪽 먼저 작업
        for (int j = 0; j < n; j++) {
            int y = nums1[j];
            left[j] = query(pos2[y] - 1, bit);  // y보다 왼쪽인 것 개수
            update(pos2[y], n, bit);
        }

        // 오른쪽 작업
        bit = new int[n + 1];
        for (int j = n - 1; j >= 0; j--) {
            int y = nums1[j];
            int right = query(n - 1, bit) - query(pos2[y], bit);  // y보다 오른쪽인 것 개수
            answer += (long) left[j] * right;
            update(pos2[y], n, bit);
        }

        return answer;
    }

    private void update(int i, int n, int[] bit) {
        for (i++; i <= n; i += i & (-i))
            bit[i]++;
    }

    private int query(int i, int[] bit) {
        int sum = 0;
        for (i++; i > 0; i -= i & (-i))
            sum += bit[i];
        return sum;
    }
}
