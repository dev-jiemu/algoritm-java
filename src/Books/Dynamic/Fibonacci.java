package src.Books.Dynamic;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class Fibonacci {

    // 이미 계산했는지 체크
    // 프로그램을 여러번 실행시켰을때 앞에서 한 연산을 또 할 필요가 없게끔 처리
    private final int[] mem = new int[100001];
    private int fibonacci(int n) {
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;
        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }

    public int solution(int n) {
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(n);
        }
        return fibonacci(n);
    }
}
