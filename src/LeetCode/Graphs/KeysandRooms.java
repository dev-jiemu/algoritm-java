package src.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();
            List<Integer> current = rooms.get(room);
            for (int i = 0; i < current.size(); i++) {
                if (!visited[current.get(i)]) {
                    visited[current.get(i)] = true;
                    queue.offer(current.get(i));
                }
            }
        }

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }

        return true;
    }
}
