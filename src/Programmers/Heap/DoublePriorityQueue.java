package src.Programmers.Heap;


import java.util.Comparator;
import java.util.PriorityQueue;

// 내림차순으로 정렬하는 Heap(maxHeap)과 오름차순으로 정렬하는 Heap(minHeap) 이 필요함
class DualPriorityQueue {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public DualPriorityQueue() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void add(Integer element) {
        maxHeap.add(element);
        minHeap.add(element);
    }

    public Integer pollMax() {
        minHeap.remove(maxHeap.peek());
        return maxHeap.poll();
    }

    public Integer pollMin() {
        maxHeap.remove(minHeap.peek());
        return minHeap.poll();
    }

    public boolean maxIsEmpty() {
        return maxHeap.isEmpty();
    }

    public boolean minIsEmpty() {
        return minHeap.isEmpty();
    }
}


// 이중우선순위큐
public class DoublePriorityQueue {

    // I 숫자 : insert
    // D 숫자 : max queue delete
    // D -숫자 : min queue delete
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        DualPriorityQueue dualPriorityQueue = new DualPriorityQueue();

        for (String operation : operations) {
            String[] operateSplit = operation.split(" ");
            if ("I".equals(operateSplit[0])) {
                dualPriorityQueue.add(Integer.parseInt(operateSplit[1]));
            } else if ("D".equals(operateSplit[0]) && (!dualPriorityQueue.maxIsEmpty() && !dualPriorityQueue.minIsEmpty())) {
                if ("-1".equals(operateSplit[1])) {
                    dualPriorityQueue.pollMin();
                } else {
                    dualPriorityQueue.pollMax();
                }
            }
        }

        if (!dualPriorityQueue.maxIsEmpty()) {
            answer[0] = dualPriorityQueue.pollMax();
        }

        if (!dualPriorityQueue.minIsEmpty()) {
            answer[1] = dualPriorityQueue.pollMin();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        DoublePriorityQueue doubleQueue = new DoublePriorityQueue();
        int[] answer = doubleQueue.solution(operations);

        for (int item : answer) {
            System.out.println(item);
        }
    }

}
