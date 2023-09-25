package src.Programmers.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class Bridge {
    int weight = 0;
    int pointer = 0;

    public Bridge(int weight, int pointer) {
        this.weight = weight;
        this.pointer = pointer;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getPointer() {
        return this.pointer;
    }

    public void addPointer() {
        this.pointer++;
    }
}

public class TruckPassingBridge {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> truckQueue = new LinkedList<>();
        for (int item : truck_weights) {
            truckQueue.add(item);
        }

        Queue<Bridge> bridgeQueue = new LinkedList<>();


        while (!truckQueue.isEmpty() || !bridgeQueue.isEmpty()) {
            answer++;

            // 다리를 완전히 지난 트럭은 poll 함
            if (!bridgeQueue.isEmpty() && bridgeQueue.peek().getPointer() == bridge_length) {
                bridgeQueue.poll();
            }

            int currentWeight = 0;

            // 현재 다리 위 트럭 무게 합 구하기
            for (Bridge item : bridgeQueue) {
                currentWeight += item.getWeight();
            }

            if (!truckQueue.isEmpty() && currentWeight + truckQueue.peek() <= weight) {
                bridgeQueue.add(new Bridge(truckQueue.poll(), 0));
            }

            // 다리 위 트럭들의 pointer 증가
            for (Bridge item : bridgeQueue) {
                item.addPointer();
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7, 4, 5, 6};

        int result = solution(bridge_length, weight, truck_weights);

        System.out.println("result : " + result);
    }
}
