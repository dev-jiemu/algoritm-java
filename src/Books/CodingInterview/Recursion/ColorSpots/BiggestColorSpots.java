package src.Books.CodingInterview.Recursion.ColorSpots;

// row x cols 사이즈의 지도
// 최대로 연결된 칸 집합의 색과 포함된 칸의 개수
// = 가장 큰 색의 영역
public class BiggestColorSpots {
    // -1 곱하면 방문한거임
    // (-1, 0), (1, 0), (0, -1). (0, 1)

    // 첫칸과 연결된 영역을 가장 큰 영역이라고 가정 하고, 더 큰 영역을 찾았으면 이걸로 바꿔줌

    private int currentColorSpot;

    // 색 영역 크기
    void determineBiggestColorSpot(int cols, int rows, int a[][]){
        int biggestColorSpot = 0;
        int color = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(a[i][j] > 0) {
                    currentColorSpot = 0;
                    computeColorSpot(i, j, cols, rows, a, a[i][j]);

                    if (currentColorSpot > biggestColorSpot) {
                        biggestColorSpot = currentColorSpot;
                        color = a[i][j] * (-1);
                    }
                }
            }
        }

        System.out.println("\nColor: " + color + " Bigest spot: " + biggestColorSpot);
    }

    private void computeColorSpot(int i, int j, int cols, int rows, int a[][], int color) {
        a[i][j] = -a[i][j]; // 방문함
        currentColorSpot++;

        if (i > 1 && a[i - 1][j] == color) {
            computeColorSpot(i - 1, j, cols, rows, a, color);
        }

        if ((i + 1) < rows && a[i + 1][j] == color) {
            computeColorSpot(i + 1, j, cols, rows, a, color);
        }

        if (j > 1 && a[i][j - 1] == color) {
            computeColorSpot(i, j - 1, cols, rows, a, color);
        }

        if ((j + 1) < cols && a[i][j + 1] == color) {
            computeColorSpot(i, j + 1, cols, rows, a, color);
        }
    }
}
