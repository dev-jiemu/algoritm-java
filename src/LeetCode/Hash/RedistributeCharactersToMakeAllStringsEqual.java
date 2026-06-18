package src.LeetCode.Hash;

// 1897. Redistribute Characters to Make All Strings Equal
// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/
public class RedistributeCharactersToMakeAllStringsEqual {
    // hash 로 풀어도 되는데, 어차피 문제가 소문자밖에 없어서 배열 26개로 될듯
    // word, word[i] 둘다 사이즈가 100개라는 제한이 있어서 O^2 괜찮음 ㅇㅂㅇ
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];

        for (int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                count[c - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}
