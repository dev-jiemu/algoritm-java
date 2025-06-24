package src.LeetCode.Hash;

import java.util.HashMap;
import java.util.Map;

public class EqualRowandColumnPairs {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            String row = grid[i][0] + "," + grid[i][1] + "," + grid[i][2];
            count.put(row, count.getOrDefault(row, 0) + 1);
        }

        for (int j = 0; j < grid[0].length; j++) {
            String col = grid[0][j] + "," + grid[1][j] + "," + grid[2][j];
            count.put(col, count.getOrDefault(col, 0) + 1);
        }

        return count.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
