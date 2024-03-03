package src.Books.ProgrammersTest.PCCP;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121686
public class OperatingSystem {

    private static class Program {
        public final int priority;
        public final int calledAt;
        public final int executionTime;

        public Program(int priority, int calledAt, int executionTime) {
            this.priority = priority;
            this.calledAt = calledAt;
            this.executionTime = executionTime;
        }
    }

    // queue로 구현하면 될것 같은데 ㅇㅇ
    public long[] solution(int[][] program) {
        Queue<Program> programs = Arrays.stream(program)
                .map(p -> new Program(p[0], p[1], p[2]))
                .sorted(Comparator.comparingInt(p -> p.calledAt))
                .collect(Collectors.toCollection(LinkedList::new));

        // 우선순위 큐
        PriorityQueue<Program> pq = new PriorityQueue<>((a, b) -> {
            if(a.priority != b.priority) {
                return a.priority - b.priority;
            }

            return a.calledAt - b.calledAt;
        });

        long[] waitTimes = new long[11];

        int time = 0;
        while(!programs.isEmpty() || !pq.isEmpty()) {
            while(!programs.isEmpty() && time >= programs.peek().calledAt) {
                pq.add(programs.poll()); // 현재 시간보다 일찍 호출된 프로그램들을 대기모드로 전환
            }

            if (pq.isEmpty()) {
                time = programs.peek().calledAt;
                continue;
            }

            Program p = pq.poll();
            waitTimes[p.priority] += time - p.calledAt; // calledAt에 호출되어서 time에 실행되었으므로 = 대기시간

            time += p.executionTime;
        }

        waitTimes[0] = time;

        return waitTimes;
    }
}
