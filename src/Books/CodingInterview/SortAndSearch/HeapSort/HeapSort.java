package src.Books.CodingInterview.SortAndSearch.HeapSort;

public class HeapSort {
    // 힙정렬 : 이진 완전 트리
    // 중복요소의 순서를 보장하는 안정적인 알고리즘은 아님 ㅇㅂㅇ
    public static void sort(int[] arr) {
        buildHeap(arr, arr.length);
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int greater;

        if (left < n && arr[left] > arr[i]) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && arr[right] > arr[greater]) { // right 가 더 크면
            greater = right;
        }

        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, greater);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = y;
        arr[y] = temp;
    }
}
