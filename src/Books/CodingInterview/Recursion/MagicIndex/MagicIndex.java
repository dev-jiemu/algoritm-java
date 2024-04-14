package src.Books.CodingInterview.Recursion.MagicIndex;


public class MagicIndex {
    // 중복된 요소가 있으면 마법의 인덱스가 어느쪽에 있는지 모름
    // 그래서 양방향 다 탐색해야함
    public static int find(int[] arr) {
        if (arr == null) { return -1; }

        return find(arr, 0, arr.length - 1);
    }

    private static int find(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) { return -1; }

        // 인덱스 개수 반으로 줄임
        int middleIndex = (startIndex + endIndex) / 2;

        int value = arr[middleIndex];

        if (value == middleIndex) {
            return middleIndex;
        }

        // 왼쪽 검색
        int leftIndex = find(arr, startIndex, Math.min(middleIndex - 1, value));
        if (leftIndex >= 0) {
            return leftIndex;
        }

        // 오른쪽 검색
        return find(arr, Math.max(middleIndex + 1, value), endIndex);
    }
}
