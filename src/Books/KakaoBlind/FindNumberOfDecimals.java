package src.Books.KakaoBlind;

// https://school.programmers.co.kr/learn/courses/30/lessons/92335
public class FindNumberOfDecimals {
    public int solution(int n, int k) {
        String[] tokens = Long.toString(n, k).split("0+"); // 0이 연속으로 생길수도 있으니

        int count = 0;
        for (String token : tokens) {
            if (isPrime(Long.parseLong(token))) count++;
        }

        return count;
    }

    private boolean isPrime(long v) {
        if (v <= 1) return false;

        for (long i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }

        return true;
    }
}
