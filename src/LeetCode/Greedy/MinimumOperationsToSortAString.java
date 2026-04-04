package src.LeetCode.Greedy;

public class MinimumOperationsToSortAString {
    public int minOperations(String s) {
        int n = s.length();

        int minIdx = 0;
        int maxIdx = 0;

        // length 가 2이고 정렬 안됐으면 return -1
        if (n == 2){
            return s.charAt(0) <= s.charAt(1) ? 0 : -1;
        }

        for(int i = 0; i < n; i++) {
            if (s.charAt(i) < s.charAt(minIdx)) {
                minIdx = i;
            }
            if (s.charAt(i) >= s.charAt(maxIdx)) {
                maxIdx = i;
            }
        }

        // 정렬 안된거, 또는 애당초 정렬된거 판단하기
        boolean isSorted = true;
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) > s.charAt(i+1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;


        if (minIdx == 0 || maxIdx == n -1) {
            return 1;
        } else if (minIdx == n -1 && maxIdx == 0) {
            return 3;
        }

        return 2;
    }
}
