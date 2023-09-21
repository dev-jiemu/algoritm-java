package src.Programmers.StackAndQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class OperatingSystem {

    private int index; // 위치하고 있던 인덱스
    private int priority; // 우선순위 중요도

    public OperatingSystem(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getIndex() {
        return this.index;
    }

}

public class OperatingSystemProcess {

    public static void main(String[] args) {
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;

        int result = solution(priorities, location);
        System.out.println("result : " + result);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<OperatingSystem> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new OperatingSystem(i, priorities[i]));
        }

        // 우선순위 저장하는 queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            priorityQueue.add(priority);
        }

        while (!queue.isEmpty()) {
            OperatingSystem os = queue.poll();
            if (os.getPriority() < priorityQueue.peek()) {
                queue.add(os);
            } else {
                answer++;
                priorityQueue.poll(); // 우선순위 높은거 처리되었으니 뺌
                if (os.getIndex() == location) {
                    break;
                }
            }
        }

        return answer;
    }

}