package src.Books.CodingInterview.Recursion.Staircase;

// 계단 올라가는 모든 경우의 수
public class Staircase {
    // 메모이제이션 처리
    public static int countViaMemorization(int n) {
        int[] cache = new int[n + 1];
        return count(n, cache);
    }

    private static int count(int n, int[] cache) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (cache[n] > 0) {
            return cache[n];
        }

        cache[n] = count(n - 1, cache) + count(n - 2, cache) + count(n - 3, cache); // 1, 2, 3칸씩 건너뛸때
        return cache[n];
    }

    // 메모이제이션 아닌 경우
    public static int count(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        return count(n - 1) + count(n - 2) + count(n - 3);
    }
}
