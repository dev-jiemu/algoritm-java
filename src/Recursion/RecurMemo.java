package src.Recursion;

import java.util.Scanner;

// 재귀: 메모화
public class RecurMemo {

    static String[] memo;
    static int callRecur; // 메서드 호출 횟수

    static void recur(int n) {
        callRecur = callRecur + 1;
        if (memo[n + 1] != null) {
            System.out.println(memo[n + 1]); // 메모 출력
        } else {
            if (n > 0) {
                recur(n - 1);
                System.out.println(n);
                recur(n - 2);
                memo[n + 1] = memo[n] + n +"\n" + memo[n - 1];
            } else {
                memo[n + 1] = ""; //recur(0), recur(-1)은 빈 문자열 처리
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        memo = new String[x + 2];
        recur(x);

        System.out.println("총 재귀 호출 횟수 : " + callRecur);
    }
}
