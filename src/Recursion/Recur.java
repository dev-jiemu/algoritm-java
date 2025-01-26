package src.Recursion;

import src.Stack.IntStack;
import java.util.Scanner;

// 재귀함수 이해해보기
public class Recur {

    // 아래 두 케이스는 하향식 분석을 통해 재귀가 중복되는 문제가 존재함.
//    static void recur(int n) {
//        // genuinely 재귀
//        if (n > 0) {
//            recur(n - 1);
//            System.out.println(n);
//            recur(n - 2);
//        }
//    }

    // 꼬리 재귀를 제거해봄
//    static void recur(int n) {
//        while (n > 0) {
//            recur(n - 1);
//            System.out.println(n);
//            n = n - 2;
//        }
//    }

    // 재귀 자체를 제거해봄
    static void recur(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }
            if (s.isEmpty() != true) { // 스택이 비어있지 않으면 pop 처리
                n = s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        recur(x);
    }
}
