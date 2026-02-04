package src.LeetCode.Binary;

// https://leetcode.com/problems/reverse-string/description/?envType=problem-list-v2&envId=two-pointers
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
