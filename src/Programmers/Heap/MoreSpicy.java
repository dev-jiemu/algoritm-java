package src.Programmers.Heap;

import java.util.PriorityQueue;

public class MoreSpicy {

    // 초기버전
//    public int solution(int[] scoville, int K) {
//        int answer = 0;
//
//        // 오름차순으로 정렬
//        PriorityQueue<Integer> scovilQueue = new PriorityQueue<>();
//        // K보다 높은 경우일때만 모아놓음
//        Queue<Integer> result = new LinkedList<>();
//
//        for (int item : scoville) {
//            scovilQueue.add(item);
//        }
//
//        while(!scovilQueue.isEmpty()) {
//            int current = scovilQueue.poll();
//
//            if (current >= K) {
//                result.add(current);
//            } else if (scovilQueue.size() > 0){
//                int next = current + (scovilQueue.poll() * 2);
//                scovilQueue.add(next);
//                answer++;
//            }
//
//        }
//
//        // 모든 음식의 스코빌지수를 K 이상으로 만들지 못했다면
//        if (result.size() == 0) {
//            answer = -1;
//        }
//
//        return answer;
//    }

    // 리팩토링버전
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 오름차순으로 정렬
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

        for (int item : scoville) {
            scovilleQueue.add(item);
        }

        while (!scovilleQueue.isEmpty() && scovilleQueue.peek() < K) {
            int current = scovilleQueue.poll();

            if (scovilleQueue.isEmpty()) {
                return -1;
            }

            int next = current + (scovilleQueue.poll() * 2);
            scovilleQueue.add(next);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        MoreSpicy spicy = new MoreSpicy();

        int result = spicy.solution(scoville, 7);
        System.out.println("result : " + result);

    }
}
