package src.Books.CodingInterview.Algoritm.MergeKSortedArr;

public class MinHeap {
    int data;
    int heapIndex;
    int currentIndex;

    public MinHeap(int data, int heapIndex, int currentIndex) {
        this.data = data;
        this.currentIndex = currentIndex;
        this.heapIndex = heapIndex;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}
