package src.LeetCode.String;

// https://leetcode.com/problems/count-and-say/description/
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";

        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                result = getNext(result);
            }
        }

        return result;
    }

    private String getNext(String text) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < text.length()) {
            char current = text.charAt(i);
            int count = 1;

            while (i + 1 < text.length() && text.charAt(i + 1) == current) {
                count++;
                i++;
            }

            sb.append(count).append(current);
            i++;
        }

        return sb.toString();
    }
}
