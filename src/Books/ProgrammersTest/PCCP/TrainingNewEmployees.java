package src.Books.ProgrammersTest.PCCP;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121688
public class TrainingNewEmployees {
    // Queue
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = Arrays.stream(ability).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = 0; i < number; i++) {
            int a = pq.poll();
            int b = pq.poll();

            pq.add(a + b);
            pq.add(a + b);
        }

        return pq.stream().reduce(0, Integer::sum);
    }
}
