package src.LeetCode.Hash;

public class SmallestPalindromicRearrangementOne {
    public String smallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];

        for(char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        int midChar = -1; // 펠린드롬이라서 유일하게 홀수인 글자는 하나뿐임
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1) {
                midChar = i;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                for (int j = 0; j < arr[i] / 2; j++) {
                    sb.append((char)('a' + i));
                }
            }
        }

        // 리버스할거 따로 보관
        String left = sb.toString();

        if (midChar != -1) {
            sb.append((char)('a' + midChar));
        }

        sb.append(new StringBuilder(left).reverse());

        return sb.toString();
    }
}
