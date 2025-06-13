package src.LeetCode.Array;

// https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
public class StringCompression {
    public int compress(char[] chars) {
        int result = 0;
        int index = 0;

        while(index < chars.length){
            char current = chars[index];
            int count = 1;

            while (index + count < chars.length && chars[index + count] == current) {
                count++;
            }

            chars[result++] = current;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char digit : countStr.toCharArray()) {
                    chars[result++] = digit;
                }
            }

            index += count;
        }

        return result;
    }
}
