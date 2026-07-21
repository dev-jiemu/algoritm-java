// 2937. Make Three Strings Equal
// https://leetcode.com/problems/make-three-strings-equal/description/
public class MakeThreeStringsEqual {
  public int findMinimumOperations(String s1, String s2, String s3) {
    int minLen = Math.min(Math.min(s1.length(), s2.length()), s3.length());
    int prefix = 0;

    // 처음에 if 문으로 했다가, 세 문자열의 길이가 전부 같은데 맨 끝만 다른 경우 -1이 되버려서 수정
    while (prefix < minLen && s1.charAt(prefix) == s2.charAt(prefix) && s2.charAt(prefix) == s3.charAt(prefix)) {
      prefix++;
    }

    if (prefix == 0) {
      return -1;
    }

    return s1.length() + s2.length() + s3.length() - 3 * prefix;
  }
}
