package src.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75
public class NearestExitfromEntranceinMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>(); // 거리 데이터도 넣기
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        int[][] visited = new int[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = 1; // 시작점 방문 표시

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            // 출구면 return 처리 (시작점 아니면!)
            if (!(current[0] == entrance[0] && current[1] == entrance[1]) && (isBoundary(current[0], maze.length - 1) || isBoundary(current[1], maze[0].length - 1))) {
                return current[2];
            }

            // 아래
            if (isValid(current[0] + 1, current[1], visited, maze)) {
                queue.add(new int[]{current[0] + 1, current[1], current[2] + 1});
                visited[current[0] + 1][current[1]] = 1;
            }

            // 위
            if (isValid(current[0] - 1, current[1], visited, maze)) {
                queue.add(new int[]{current[0] - 1, current[1], current[2] + 1});
                visited[current[0] - 1][current[1]] = 1;
            }

            // 왼쪽
            if (isValid(current[0], current[1] - 1, visited, maze)) {
                queue.add(new int[]{current[0], current[1] - 1, current[2] + 1});
                visited[current[0]][current[1] - 1] = 1;
            }

            // 오른쪽
            if (isValid(current[0], current[1] + 1, visited, maze)) {
                queue.add(new int[]{current[0], current[1] + 1, current[2] + 1});
                visited[current[0]][current[1] + 1] = 1;
            }
        }

        return -1; // 못찾음
    }

    private boolean isBoundary(int current, int length) {
        return current == 0 || current == length;
    }

    private boolean isValid(int x, int y, int[][] visited, char[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && visited[x][y] == 0 && maze[x][y] == '.';
    }
}
