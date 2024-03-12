package src.Books.CodingInterview.Recursion.Josephus;

import java.util.ArrayDeque;
import java.util.Queue;

// 03. 요세푸스
public class Josephus {
    // n번째를 계산하라 = 재귀

    /*
    n = 15, k = 3이라고 가정하면
    1라운드 : 3, 6, 9, 12, 15
    2라운드 : 4, 8, 13
    3라운드 : 2, 10, 1
    ...
     */
    // 첫번째 사람이 제외된 후 = n - 1 사람이 남음 = josephus(n-1, k)
    // josephus(n-1, k) 가 반환하는 위치 = k % n + 1
    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }

    // Queue로도 풀어낼수 있음 ㅇㅇ
    public static void printJosephus(int n, int k) {
        Queue<Integer> circle = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // 사이즈 만큼 돌리는데
        while(circle.size() != 1) {
            for(int i = 1; i <= k; i++) { // 인덱스로 접근함
                Integer eliminated = circle.poll();
                if (eliminated != null) {
                    if (i == k) {
                        System.out.println("Eliminated: " + eliminated);
                        break;
                    }
                    circle.add(eliminated);
                }
            }
        }

        System.out.println("Using queue! Survivor: " + circle.peek());
    }

    public static void main(String[] args) {
        int n = 15;
        int k = 3;

        // 재귀
        System.out.println("Using recursion! Survivor: " + Josephus.josephus(n, k) + "\n");

        System.out.println("=============================");
        Josephus.printJosephus(n, k);
    }

}
