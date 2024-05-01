package src.Books.CodingInterview.Recursion.Braces;

import java.util.ArrayList;
import java.util.List;

public class Braces {
    // 중괄호 쌍 n개 유효한 조합 전부 찾아내기
    public static List<String> embrace(int n) {
        List<String> results = new ArrayList<>();
        embrace(n, n, new char[n * 2], 0, results);

        return results;
    }

    // 모든 왼쪽 중갈화를 재귀 방식으로 추가함
    // 오른쪽 중괄호의 개수가 왼쪽 중괄호의 수를 초과하지 않는 선에서 오른쪽 중괄호를 재귀 방식으로 추가함
    // 총 괄호의 개수는 2n개가 넘지 않아야 함
    private static void embrace(int left, int right, char[] str, int index, List<String> results) {
        if (left == 0 && right == 0) {
            results.add(String.valueOf(str));
        } else {
            str[index] = '{';
            embrace(left - 1, right, str, index + 1, results);

            str[index] = '}';
            embrace(left, right - 1, str, index + 1, results);
        }
    }
}
