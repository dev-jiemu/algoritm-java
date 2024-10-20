package src.Books.CodingInterview.Algoritm.SearchInCircularArray;

// 중복이 없는 정수 원형배열 m의 검색
// 단, 0(logn)으로 풀어야 함
// = 이진검색 응용해야할듯
public class SearchArrays {

    // 1. 일단 중간 인덱스 찾고
    // 2. m[middle] <= m[right] 을 만족하는지 체크하고 (정렬 되어있는지)
    //    만약, 배열 오른쪽이 정렬된 상태가 아니면 왼쪽이 정렬되어 있어야 함
    // 3. 중앙값과 x값을 비교해서 한칸씩 이동해서 반복 비교
    public static int find(int[] m, int x) {
        int left = 0;
        int right = m.length - 1;

        while(left <= right) {
            int middle = (left + right) / 2;

            if (m[middle] == x) {
                return middle;
            }

            if (m[middle] <= m[right]) { // 오른쪽 정렬되어 있는지 확인
                if (x > m[middle] && x <= m[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else { // 만약 오른쪽이 정렬 안되어있다면 왼쪽이 정렬된 상태
                if (x >= m[left] && x < m[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }


        }

        return -1;
    }
}
