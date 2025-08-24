package src.LeetCode.Array;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder result = new StringBuilder();

        // 각 인덱스별로 모든 문자열의 문자가 같은지 확인
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    return result.toString();
                }
            }

            result.append(currentChar);
        }

        return result.toString();
    }
}
