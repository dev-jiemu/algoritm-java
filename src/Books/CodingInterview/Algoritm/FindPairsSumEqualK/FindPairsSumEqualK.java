package src.Books.CodingInterview.Algoritm.FindPairsSumEqualK;

import java.util.ArrayList;
import java.util.List;

public class FindPairsSumEqualK {
    /*
        12. 쌍
        - 브루트 포스 방법으로 풀순 있긴 한데 효율성이 떨어짐
        - ** 정렬 하고나서 ** 투포인터 방법으로 접근
        - m[l] + m[r] = k ==> 찾음
        - m[l] + m[r] < k 이면 l 증가, 그 반대면 r을 감소(그 반대는 유지)
     */
    public static List<String> pairs(int[] m, int k) {
        List<String> result = new ArrayList<>();

        java.util.Arrays.sort(m);

        int l = 0;
        int r = m.length - 1;

        while(l < r) {
            int sum = m[l] + m[r];

            if (sum == k) {
                result.add("(" + m[l] + " + " + m[r] + ")");
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            }
        }

        return result;
    }

}
