package src.LeetCode.String;

// 388. Longest Absolute File Path
// https://leetcode.com/problems/longest-absolute-file-path/description/
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] lengthAtDepth = new int[lines.length + 1];
        int maxLength = 0;

        for (String line : lines) {
            int depth = line.lastIndexOf("\t") + 1; // depth 파악
            String name = line.substring(depth);

            int currentLength = lengthAtDepth[depth] + name.length() + 1;

            if (name.contains(".")) { // 파일인 경우 마지막 / 제외
                maxLength = Math.max(maxLength, currentLength - 1);
            } else { // 디렉토리인 경우
                lengthAtDepth[depth + 1] = currentLength;
            }
        }

        return maxLength;
    }
}
