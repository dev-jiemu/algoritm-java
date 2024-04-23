package src.Books.CodingInterview.Recursion.KnightTour;

public class KnightTour {
    private final int n = 0;

    // 움직일 수 있는 8가지 경로
    public static final int COL[] = {1, 2, 2, 1, -1, -2, -2, -1, 1};
    public static final int ROW[] = {2, 1, -1, -2, -2, -1, 1, 2, 2};

    public void knightTour(int r, int c, int cell, int[][] visited) {

        // 현재 칸 방문함
        visited[r][c] = cell;

        if (cell >= n * n) { // 이미 경로를 찾은 경우 프린트
            print(visited);

            visited[r][c] = 0;
            return;
        }

        for (int i = 0; i < (ROW.length); i++) {
            int newR = r + ROW[i];
            int newC = c + COL[i];

            if (isValid(newR, newC) && visited[newR][newC] == 0) {
                knightTour(newR, newC, cell+1, visited);
            }
        }

        visited[r][c] = 0;
    }

    // 유효한가 체크
    private boolean isValid(int r, int c) {
        return !(r < 0 || c < 0 || r >= n || c >= n);
    }

    private void print(int[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.format("%3s", visited[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
