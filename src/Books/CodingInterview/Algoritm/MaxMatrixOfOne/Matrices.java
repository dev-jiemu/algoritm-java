package src.Books.CodingInterview.Algoritm.MaxMatrixOfOne;

public class Matrices {
    // subMatrix max = 최대 서브 배열임

    // 브루트 포스 방법으로 하면?
    public static int ofOne(int[][] matrix) {
        int maxSubMatrixSize = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int k = 1; k <= Math.max(cols, rows); k++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int temp = 1;

                    if ((i + k) > rows || (j + k) > cols) {
                        continue;
                    }

                    for (int x = i; x < (i + k); x++) {
                        for (int y = j; y < (j + k); y++) {
                            if (matrix[x][y] == 0) {
                                temp = 0;
                                break;
                            }
                        }
                    }

                    if (temp == 1) {
                        maxSubMatrixSize = Math.max(maxSubMatrixSize, k);
                    }
                }
            }
        }

        return maxSubMatrixSize;
    }


    // 동적 프로그래밍
    public static int ofOneOptimized(int[][] matrix) {
        int maxSubMatrixSize = 1;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] subMatrix = new int[rows][cols];

        // 첫번째 행, 열 복사
        for (int i = 0; i < cols; i++) {
            subMatrix[0][i] = matrix[0][i];
        }

        for (int i = 0; i < rows; i++) {
            subMatrix[i][0] = matrix[i][0];
        }

        // 1인지 확인
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    subMatrix[i][j] = Math.min(subMatrix[i - 1][j - 1], Math.min(subMatrix[i][j - 1], subMatrix[i - 1][j]) + 1);

                    maxSubMatrixSize = Math.max(maxSubMatrixSize, subMatrix[i][j]);
                }
            }
        }

        // output
        for (int i = 0; i < subMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < subMatrix[i].length; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
        }

        return maxSubMatrixSize;
    }
}
