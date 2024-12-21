package src.Books.CodingInterview.Algoritm.CountDistinctAbsoluteSortedArray;

public class CountDistinctAbsolute {
    // 배열 m 에서 고유한 절대값 개수 찾는 코드
    // 슬라이딩 윈도 기법

    public static int findAbsoluteDistinct(int[] m) {
        int count = m.length;

        int left = 0;
        int right = m.length - 1;

        while(left < right) {
            
            // 중복요소 체크
            while(left < right && m[left] == m[left + 1]) {
                count--;
                left++;
            }

            while (right > left && m[right] == m[right - 1]) {
                count--;
                right--;
            }

            if (left == right) {
                break;
            }

            int sum = m[left] + m[right];

            if (sum == 0) {
                count--;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
