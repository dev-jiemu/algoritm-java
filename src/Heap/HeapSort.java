package src.Heap;

public class HeapSort {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];
        int child = 0, parent = 0;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰 값은 자식으로
            if (temp >= a[child]) {
                break;
            }

            a[parent] = a[child];
        }

        a[parent] = temp;
    }

    // 힙 정렬
    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) { // a[i] ~ a[n-1] 을 힙으로 만듬
            downHeap(a, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) { 
            swap(a, 0, i); //a[0] 에 있는 가장 큰 값을 마지막 요소랑 교환
            downHeap(a, 0, i - 1); // 다시 힙으로 전환
        }
    }
}
