package src.LeetCode.Hash;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/walking-robot-simulation/
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 북 -> 동 -> 남 -> 서 순임
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dir = 0;
        int x = 0;
        int y = 0;
        int maxDist = 0;

        // 장애물
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        for(int i = 0; i < commands.length; i++) {
            int command = commands[i];

            if (command == -2) { // 왼쪽으로 회전
                dir = (dir + 3) % 4;
            } else if (command == -1) { // 오른쪽으로 회전
                dir = (dir + 1) % 4;
            } else {
                for(int step = 0; step < command; step++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    if (obstacleSet.contains(nx + "," + ny)) {
                        break; // 장애물 만나면 즉시 멈춤
                    }

                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}
