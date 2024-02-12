package src.Books.CodingInterview.Recursion.RobotGridMaze;

import java.awt.*;
import java.util.Set;

public class RobotGrid {
    // m x n 크기의 격자 지도
    // 한번에 오른쪽 또는 아래로만 한칸씩만 이동 가능
    // 특정 칸으로는 이동할 수 없음
    // 왼쪽 맨 위 칸에서 오른쪽 맨 아래칸까지 가는 경로 찾는 방법

    // maze : 못가는 칸 위치
    // ex) maze[3][1] = true ==> (3, 1)은 못감
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path) {
        // 모서리에서 벗어남
        if(m < 0 || n < 0){
            return false;
        }

        if (maze[m][n]) {
            return false; // 여기는 못감
        }

        if (((m == 0) && (n == 0)
        || computePath(m, n - 1, maze, path)
        || computePath(m - 1, n, maze, path))) {
            path.add(new Point(m, n)); // 해당 칸을 경로로 추가홤

            return true;
        }

        return false;
    }

    // 메모이제이션 : 이동할 수 없는 칸에는 여러번 접근 못하게 함
    public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path, Set<Point> visitFailed) {
        if (m < 0 || n < 0) {
            return false;
        }

        if (maze[m][n]) {
            return false;
        }

        Point cell = new Point(m, n);

        // 이미 해당 칸을 방문한 적이 있는지 확인
        if (visitFailed.contains(cell)) {
            return false;
        }

        if (((m == 0) && (n == 0))
                || computePath(m, n - 1, maze, path, visitFailed) // 또는 오른쪽으로 이동할 수 있습니다.
                || computePath(m - 1, n, maze, path, visitFailed)) { // 또는 아래쪽으로 이동할 수 있습니다.
            path.add(cell);

            return true;
        }

        visitFailed.add(cell);

        return false;
    }
}
