package src.LeetCode.BFSandDFS;

import java.util.*;

// https://leetcode.com/problems/get-watched-videos-by-your-friends/
public class GetWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[friends.length];

        Map<String, Integer> map = new HashMap<>();

        queue.add(id);
        visited[id] = true;

        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int person = queue.poll();

                if (currentLevel == level) {
                    for (String video : watchedVideos.get(person)) {
                        map.put(video, map.getOrDefault(video, 0) + 1);
                    }
                    continue;
                }

                for (int friend : friends[person]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.add(friend);
                    }
                }
            }
            currentLevel++;
        }

        List<String> result = new ArrayList<>(map.keySet());

        result.sort((a, b) -> {
            int freqDiff = map.get(a) - map.get(b);
            return freqDiff != 0 ? freqDiff : a.compareTo(b);
        });

        return result;
    }
}
