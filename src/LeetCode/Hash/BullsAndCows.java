package src.LeetCode.Hash;

// https://leetcode.com/problems/bulls-and-cows/description/?envType=problem-list-v2&envId=hash-table
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for(int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else { // boll 이 아닌것만 카운트 증가
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        for(int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
