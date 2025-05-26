package src.LeetCode.Array;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
public class GreatestCommonDivisorofStrings {
    // 문자열의 최대공약수
    // 가장 긴 공통 divisor를 찾으려면 -> 가장 큰 공통 약수를 찾아야 함 -> GCD
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int length = gcb(str1.length(), str2.length());
        return str1.substring(0, length);
    }

    // 최대공약수 계산
    private int gcb(int a, int b) {
        if (b == 0) return a;
        return gcb(b, a % b);
    }
}
