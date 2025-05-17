package src.LeetCode.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {
    private Queue<Integer> queue = new LinkedList<>();

    // 카운터 요청 생성자
    public NumberofRecentCalls() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        int result = 0;

        // 새 요청에 대해 push
        this.queue.add(t);

        for(int current : this.queue) {
            if (current >= t - 3000 && current <= t) {
                result++;
            }
        }

        return result;
    }
}
