package src.Books.CodingInterview.Recursion.FiveTowers;

import java.util.Set;

// 5개의 탑: 타워가 대각선으로 존재할 수 있는 모든 방법을 찾을것
public class FiveTower {
    protected static final int GRID_SIZE = 5; // 5 * 5

    public static void buildTowers(int row, Integer[] columns, Set<Integer[]> solutions) {
        if (row == GRID_SIZE) { // 그리드 맨 끝이라면
            solutions.add(columns.clone());
        } else {
            for(int col = 0; col < GRID_SIZE; col++) {
                if (canBuild(columns, row, col)) {
                    columns[row] = col;
                    buildTowers(row + 1, columns, solutions);
                }
            }
        }
    }

    private static boolean canBuild(Integer[] columns, int nextRow, int nextColumn) {
        for(int currentRow = 0; currentRow < nextRow; currentRow++) {
            int currentColumn = columns[currentRow];
            
            if (currentColumn == nextColumn) { // 같은 열에 못세움
                return false;
            }

            int columnsDistance = Math.abs(currentColumn - nextColumn);
            int rowsDistance = nextRow - currentRow;

            if (columnsDistance == rowsDistance) { // 같은 대각선으로 못세움
                return false;
            }
        }

        return true;
    }
}
