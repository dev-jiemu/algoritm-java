package src.Recursion;

import java.util.Scanner;

// 재귀: 팩토리얼
public class Factorial {
    static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner stdId = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdId.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
