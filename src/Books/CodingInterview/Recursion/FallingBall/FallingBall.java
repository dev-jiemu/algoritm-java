package src.Books.CodingInterview.Recursion.FallingBall;

// (i, j) / (i - 1, j) / (i + 1, j) / (i, j - 1) / (i, j + 1)
public class FallingBall {
    public static void computePath(int prevElevation, int i, int j, int rows, int cols, int[][] elevations) {  // 이 시점은 (i, j) 로 간주함
        // 4방향 전부 다 체크 :: 재귀

        if (i >= 0 && i <= (rows - 1) && j >= 0 && j <= (cols - 1)) {
            int current = elevations[i][j];

            if (prevElevation >= current && current > 0) {
                prevElevation = current;

                elevations[i][j] = 0; // 방문완료 표기

                // 재귀탐색
                computePath(prevElevation, i, j-1, rows, cols, elevations);
                computePath(prevElevation, i-1, j, rows, cols, elevations);
                computePath(prevElevation, i, j+1, rows, cols, elevations);
                computePath(prevElevation, i+1, j, rows, cols, elevations);
            }
        }
    }
}
