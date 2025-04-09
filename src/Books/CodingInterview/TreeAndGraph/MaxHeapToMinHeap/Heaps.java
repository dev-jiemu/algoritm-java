package src.Books.CodingInterview.TreeAndGraph.MaxHeapToMinHeap;

public class Heaps {
    // 상향식 기법
    public static void convertToMinHeap(int[] maxHeap) {
        int p = (maxHeap.length - 2) / 2;
        while(p >= 0) {
            heapifyMin(maxHeap, p--, maxHeap.length);
        }
    }

    private static void heapifyMin(int[] maxHeap, int p, int size) {
        int left = leftChild(p);
        int right = rightChild(p);
        int smallest = p;

        if ((left < size) && (maxHeap[left] < maxHeap[p])) {
            smallest = left;
        }

        if ((right < size) && (maxHeap[right] < maxHeap[smallest])) {
            smallest = right;
        }

        if (smallest != p) {
            swap(maxHeap, p, smallest);
            heapifyMin(maxHeap, smallest, size);
        }
    }

    private static int leftChild(int parentIndex) {
        return (2 * parentIndex + 1);
    }

    private static int rightChild(int parentIndex) {
        return (2 * parentIndex + 2);
    }

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
