package src.LeetCode.String;

// 3084. Count Substrings Starting and Ending with Given Character
// https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/
public class CountSubstringsStartingAndEndingWithGivenCharacter {
    public long countSubstrings(String s, char c) {
        // s 에서 문자 c 의 등장 횟수 = cnt
        // cnt = 단독등장
        // 다른 c와 쌍을 이루는 경우 = cnt * (cnt - 1) / 2
        long cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                cnt++;
            }
        }

        // cnt * cnt + (cnt - 1) / 2
        // ==> cnt * (cnt + 1) / 2
        // Ref. https://leetcode.ca/2024-04-04-3084-Count-Substrings-Starting-and-Ending-with-Given-Character/
        return cnt * (cnt + 1) / 2;
    }
}
