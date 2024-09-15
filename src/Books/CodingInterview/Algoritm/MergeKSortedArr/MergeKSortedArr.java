package src.Books.CodingInterview.Algoritm.MergeKSortedArr;

// 13. 정렬된 배열 병합
// k개 정렬된 배열을 O(nklogn) 으로 병합하는 방법
// 이진 최소 힙(완전 이진 트리)
public class MergeKSortedArr {

    /*
        heap[i - 1 / 2] = 부모
        heap[2 * i + 1] = 왼쪽 자식
        heap[2 * i + 2] = 오른쪽 자식
     */
    public static int[] merge(int[][] arrs, int k) throws Exception {
        if (arrs == null) {
            throw new Exception("the given arrays cannot be null");
        }

        if (k <= 0) {
            throw new Exception("the number of given array cannot be less or equals to 0");
        }

        int len = 0;
        for (int i = 0; i < arrs.length; i++) {
            len += arrs[i].length;
        }

        int[] result = new int[len];

        MinHeap[] heap = new MinHeap[k]; // 최소힙 생성

        for (int i = 0; i < k; i++) {
            heap[i] = new MinHeap(arrs[i][0], i, 0);
        }

        for (int i = 0; i < result.length; i++) {
            heapify(heap, 0, k);

            result[i] = heap[0].data;
            heap[0].currentIndex++;

            int[] subarray = arrs[heap[0].heapIndex];
            if (heap[0].currentIndex >= subarray.length) {
                heap[0].data = Integer.MAX_VALUE;
            } else {
                heap[0].data = subarray[heap[0].currentIndex];
            }
        }

        return result;
    }

    // O(logn) : 최소요소 제거
    private static void heapify(MinHeap[] heap, int root, int len) {
        int smallest = root;
        int leftIndex = left(root);
        int rightIndex = right(root);

        if (leftIndex < len && heap[smallest].data > heap[leftIndex].data) {
            smallest = leftIndex;
        }

        if (rightIndex < len && heap[smallest].data > heap[rightIndex].data) {
            smallest = rightIndex;
        }

        // 루트 노드로 가장 작은 요소를 교환
        if (smallest != root) {
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
    }

    private static void swap(MinHeap[] heap, int i, int j) {
        MinHeap aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    // 왼쪽 노드 자식
    private static int left(int i) {
        return (2 * i + 1);
    }

    // 오른쪽 노드 자식
    private static int right(int i) {
        return (2 * i + 2);
    }

}