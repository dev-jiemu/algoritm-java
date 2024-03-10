package src.Books.ProgrammersTest.PCCP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/15009/lessons/121690
public class TreasureMap {
    // BFS
    private static class State {
        public final int x;
        public final int y;
        public final int canJump;
        public final int step;

        public State(int x, int y, int canJump, int step) {
            this.x = x;
            this.y = y;
            this.canJump = canJump;
            this.step = step;
        }
    }

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public int solution(int n, int m, int[][] hole) {
        boolean[][] map = new boolean[m][n];
        for(boolean[] row : map) {
            Arrays.fill(row, true);
        }

         for (int[] h : hole) {
             int x = h[0] - 1;
             int y = h[1] - 1;
             map[y][x] = false; // 함정은 false
         }

         boolean[][][] isVisited = new boolean[m][n][2]; // 이미 방문했는지 여부 판단

         Queue<State> q = new LinkedList<>();
         q.add(new State(0, 0, 1, 0));
         isVisited[0][0][1] = true;

         while(!q.isEmpty()) {
             State s = q.poll();

             if (s.x == n - 1 && s.y == m - 1) {
                 return s.step;
             }

             for(int d = 0; d < 4; d++) {
                 int nx = s.x + dx[d];
                 int ny = s.y + dy[d];

                 if (ny < 0 || ny >= m || nx < 0 || nx >= n) {
                     continue;
                 }
                 if (map[ny][nx]) { // 함정이 있다면 한칸만 이동할 수 없도록 수정
                     if (isVisited[ny][nx][s.canJump]){
                         continue;
                     }
                     isVisited[ny][nx][s.canJump] = true;
                     q.add(new State(nx, ny, s.canJump, s.step + 1));
                 }

                 if (s.canJump != 1) {
                     continue;
                 }

                 int nnx = nx + dx[d];
                 int nny = ny + dy[d];

                 if(nny < 0 || nny >= m || nnx < 0 || nnx >= n) {
                     continue;
                 }
                 if (!map[nny][nnx]) {
                     continue;
                 }
                 if (isVisited[nny][nnx][0]) {
                     continue;
                 }

                 isVisited[ny][nx][0] = true;
                 q.add(new State(nnx, nny, 0, s.step + 1));
             }
         }

         return -1;
    }

    public static void main(String[] args) {
        TreasureMap treasureMap = new TreasureMap();

        int n = 5;
        int m = 4;
        int[][] hole = {{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}};

        int result = treasureMap.solution(n, m, hole);

        System.out.println("result : " + result);
    }
}
