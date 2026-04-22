package src.LeetCode.String;

// 6. Zigzag Conversion
// https://leetcode.com/problems/zigzag-conversion/description/
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1; // 1이면 아래로 내려가고, -1이면 위로 올라감
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow].append(s.charAt(i));

            currentRow += direction;

            if (currentRow == numRows - 1 || currentRow == 0) { // 방향 전환
                direction = -direction;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
