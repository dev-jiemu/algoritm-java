package src.LeetCode.String;

// 1694. Reformat Phone Number
// https://leetcode.com/problems/reformat-phone-number/
public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();

        // 공백, - 제거
        String temp = number.replaceAll(" ", "").replaceAll("-", "");

        int i = 0;
        while(temp.length() - i > 4) {
            sb.append(temp.substring(i, i + 3)).append("-");
            i += 3;
        }

        if (temp.length() - i == 4) {
            sb.append(temp.substring(i, i + 2)).append("-");
            sb.append(temp.substring(i + 2));
        } else {
            sb.append(temp.substring(i));
        }

        return sb.toString();
    }
}
