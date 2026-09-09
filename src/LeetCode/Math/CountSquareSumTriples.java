package src.LeetCode.Math;

// 1925. Count Square Sum Triples
// https://leetcode.com/problems/count-square-sum-triples/description/
public class CountSquareSumTriples {
    public int countTriples(int n) {
        int result = 0;

        // n 이 250 까지라고 문제에서 명시되어있으니 이정돈 부담 없을듯함
        for(int a = 1; a <= n; a++){
            for(int b = a; b <= n; b++) {
                int sum = a * a + b * b;
                int c = (int) Math.sqrt(sum);
                if (c <= n && c * c == sum) {
                    result += 2; // 중복 쌍도 같이 체크
                }
            }
        }

        return result;
    }
}
