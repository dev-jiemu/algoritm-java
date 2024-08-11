package src.Books.CodingInterview.Algoritm.MatrixWithZeros;

// 0을 포함하는 행렬
// 공간복잡도 O(1) 유지 : (i, j) = 0이라면 m[i][0] = 0, m[0][j] = 0으로 설정
// 이후 맨 끝에가 0이면 그냥 전부 0으로 바꾸면됨
public class MatrixWithZeros {
    public static void alignZeros(int[][] m) {

        boolean firstRowHasZeros = false;
        boolean firstColumnHasZeros = false;

        for (int j = 0; j < m[0].length; j++) {
            if (m[0][j] == 0) {
                firstRowHasZeros = true;
                break;
            }
        }

        for (int i = 0; i < m[0].length ; i++) {
            if (m[i][0] == 0) {
                firstColumnHasZeros = true;
                break;
            }
        }

        // 0을 찾을때마다 첫번째 행, 열에 0을 표시함
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if(m[i][j] == 0) {
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }

        // 바꿔치기
        for (int i = 1; i < m.length; i++) {
            if(m[i][0] == 0) {
                setRowOfZero(m, i);
            }
        }

        for (int j = 1; j < m[0].length; j++) {
            if (m[0][j] == 0) {
                setColumnOfZero(m, j);
            }
        }


        // 0 하나라도 있으면 0으로 전부 설정
        if (firstRowHasZeros) {
            setRowOfZero(m, 0);
        }

        if (firstColumnHasZeros) {
            setColumnOfZero(m, 0);
        }
    }

    private static void setRowOfZero(int[][] m, int r) {
        for (int j = 0; j < m[0].length; j++) {
            m[r][j] = 0;
        }
    }

    private static void setColumnOfZero(int[][] m, int c) {
        for (int i = 0; i < m[0].length; i++) {
            m[i][c] = 0;
        }
    }
}
