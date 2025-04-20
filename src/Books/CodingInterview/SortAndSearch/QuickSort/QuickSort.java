package src.Books.CodingInterview.SortAndSearch.QuickSort;

import src.SortAlgoritm.SelectionSort;

public class QuickSort {
    // 피벗을 기준으로 정렬하는 알고리즘
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int m = partition(arr, left, right);

            sort(arr, left, m - 1);
            sort(arr, m + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int m = left;

        for(int i = m; i < right; i++) {
            if(arr[i] <= pivot) {
                swap(arr, i, m++);
            }
        }

        swap(arr, right, m);

        return m;
    }

    private static void swap(int[] arr, int n, int m) {
        /*
          int temp = arr[n];
          arr[n] = arr[m];
          arr[m] = temp;
        */
        SelectionSort.swapElements(arr, n, m);
    }
}
