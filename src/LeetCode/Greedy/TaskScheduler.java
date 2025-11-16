package src.LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/task-scheduler/description/?envType=problem-list-v2&envId=greedy
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // (maxFreq - 1) * (n + 1) + (최대빈도를 가진 작업 개수)

        Map<Character, Integer> task = new HashMap<>();

        for(char current : tasks) {
            task.put(current, task.getOrDefault(current, 0) + 1);
        }

        int maxFreq = 0;
        int maxFreqCount = 0;
        for (int freg : task.values()) {
            if (freg > maxFreq) {
                maxFreq = freg;
                maxFreqCount = 1;
            } else if (freg == maxFreq) {
                maxFreqCount++;
            }
        }

        return Math.max((maxFreq - 1) * (n + 1) + maxFreqCount, tasks.length);
    }
}
