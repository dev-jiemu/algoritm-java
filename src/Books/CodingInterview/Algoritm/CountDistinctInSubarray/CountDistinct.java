package src.Books.CodingInterview.Algoritm.CountDistinctInSubarray;

import java.util.HashMap;
import java.util.Map;

public class CountDistinct {
    // 배열 m 에서 크기가 n 인 모든 부분 배열의 고유요소 count
    // hashmap
    public static void find(int[] m, int n) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int countDistinct = 0;

        for (int i = 0; i < m.length; i++) {
            if (i >= n) {
                frequency.putIfAbsent(m[i - n], 0);
                frequency.put(m[i - n], frequency.get(m[i - n]) - 1);

                if (frequency.get(m[i - n]) == 0) {
                    countDistinct--;
                }
            }

            // 하위요소 작업
            frequency.putIfAbsent(m[i], 0);
            frequency.put(m[i], frequency.get(m[i]) + 1);

            // 첫번째 확인
            if (frequency.get(m[i]) == 1) {
                countDistinct++;
            }

            if (i >= n - 1) {
                System.out.println("Distinct elements in the " + "sub-array [" + (i - n + 1) + ", " + i + "]" + " is " + countDistinct);
            }
        }
    }

    public static void main(String[] args) {
        int[] m = {7, 11, 11, -5, 13, 13, 13, 15, -4, -3, -4, 15, -2, 0, 0, 0, 14, 3, 7, 42, 3};
        int k = 5;

        System.out.println("Array: " + java.util.Arrays.toString(m));

        CountDistinct.find(m, k);
    }
}
