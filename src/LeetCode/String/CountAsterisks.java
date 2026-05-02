package src.LeetCode.String;

// 2315. Count Asterisks
// https://leetcode.com/problems/count-asterisks/description/
public class CountAsterisks {
    public int countAsterisks(String s) {
        int result = 0;

        String[] str = s.split("\\|");

        // 짝수 인덱스만 세기
        for(int i = 0; i < str.length; i+=2) {
            for (char c : str[i].toCharArray()) {
                if (c == '*') {
                    result++;
                }
            }
        }


        return result;
    }
}
