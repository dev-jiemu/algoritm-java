package src.LeetCode.Array;

// https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
public class LengthofLastWord {
    // 제일 긴거 찾는건줄 알았는데 마지막 단어 길이였음...ㅋㅋㅋ
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
