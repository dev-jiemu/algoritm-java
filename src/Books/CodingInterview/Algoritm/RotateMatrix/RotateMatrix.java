package src.Books.CodingInterview.Algoritm.RotateMatrix;


public class RotateMatrix {

    // ------- O(n^2)
    // 90도 회전 = 전치행렬
    // m[i][j] = m[j][i]
    private static void transport(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                int temp = m[j][i];
                m[j][i] = m[i][j];
                m[i][j] = temp;
            }
        }
    }

    // 열 반전
    private static void rotateWithTranspose(int[][] m) {
        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                int temp = m[j][i];
                m[j][i] = m[i][j];
                m[i][j] = temp;
            }
        }
    }


    // --------- 회전고리 활용
    private static void rotateRing(int[][] m) {
        int len = m.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                int temp = m[i][j];

                // 오른쪽 -> 위
                m[i][j] = m[j][len - 1 - i];

                // 아래쪽 -> 오른쪽
                m[j][len - 1 - i] = m[len - 1 - i][len - 1 - j];

                // 왼쪽 -> 아래쪽
                m[len - 1 - i][len - 1 - j] = m[len - 1 - j][i];

                // 위쪽 -> 왼쪽
                m[len - 1 - j][i] = temp;
            }
        }
    }
}
