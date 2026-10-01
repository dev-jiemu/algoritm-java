package src.LeetCode.TwoPointers;

// 1616. Split Two Strings to Make Palindrome
// https://leetcode.com/problems/split-two-strings-to-make-palindrome/
public class SplitTwoStringsToMakePalindrome {
    public boolean checkPalindromeFormation(String a, String b) {
        int n = a.length();

//        // 브루트 포스 : 시간 초과 날듯
//        for (int cut = 0; cut <= n; cut++) {
//            String s1 = a.substring(0, cut) + b.substring(cut);
//            String s2 = b.substring(0, cut) + a.substring(cut);
//            if (isPalindrome(s1, 0, n - 1) || isPalindrome(s2, 0, n - 1)) {
//                return true;
//            }
//        }
        this.check(a, b);
        // return false;
        return this.check(a, b) || this.check(b, a);
    }

    private boolean check(String first, String second) {
        int i = 0;
        int j = first.length() - 1;

        // 투포인터로 서로 맞는 곳까지 체크하기
        while(i < j && first.charAt(i) == second.charAt(j)) {
            i++;
            j--;
        }

        return isPalindrome(first, i, j) || isPalindrome(second, i, j);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
