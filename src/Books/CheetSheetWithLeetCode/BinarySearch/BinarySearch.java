package src.Books.CheetSheetWithLeetCode.BinarySearch;

public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    // 왼쪽 가장자리를 찾는 이진 탐색
    public int leftBound(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid;
            }
        }

        // 범위를 벗어났을때
        if (left >= array.length || array[left] != target) return -1;

        return left;
    }

    // 오른쪽 가장자리를 찾는 이진 탐색
    public int rightBound(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid + 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || array[right] != target) return -1;

        return left - 1;
    }
}
