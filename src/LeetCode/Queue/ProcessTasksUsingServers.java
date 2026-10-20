package src.LeetCode.Queue;

import java.util.PriorityQueue;

// 1882. Process Tasks Using Servers
// https://leetcode.com/problems/process-tasks-using-servers/description/
public class ProcessTasksUsingServers {
    // 놀고있는 서버 있으면 바로 배정
    // 놀고있는 서버가 여러대면 무게가 가장 작은 서버를 고르면 됨
    // 무게가 같으면 인덱스가 작은걸로
    // 서버 없으면 큐에서 기다리고, FIFO 순으로 진행
    public int[] assignTasks(int[] servers, int[] tasks) {
        // weight, index
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) ->
                a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        // finishTime, weight, index
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        for(int i = 0; i < servers.length; i++){
            free.offer(new int[]{servers[i], i});
        }

        int[] result = new int[tasks.length];
        long time = 0;

        for(int i = 0; i < tasks.length; i++){
            time = Math.max(time, i); // 작업이 i초에 도착함
            if(free.isEmpty()){
                time = busy.peek()[0]; // 빈 서버가 없으면 제일 빠른거
            }
            while(!busy.isEmpty() && busy.peek()[0] <= time){ // 끝난 서버 회수하기
                long[] s = busy.poll();
                free.offer(new int[]{(int) s[1], (int) s[2]});
            }

            int[] s = free.poll();
            result[i] = s[1];
            busy.offer(new long[]{time + tasks[i], s[0], s[1]});
        }

        return result;
    }
}
