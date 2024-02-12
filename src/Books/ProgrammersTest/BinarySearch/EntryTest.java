package src.Books.ProgrammersTest.BinarySearch;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class EntryTest {
    // 입국심사를 기다리는 사람 n, 각 심사관이 한명 심사할때 걸리는 시간 times
    public long solution(int n, int[] times) {
        // 각 심사대가 시간 t 동안 처리할 수 있는 입국 심사 개수를 모두 더한 후 기다리는 사람 수와 비교
        long start = 0;
        long end = 1000000000000000000L;

        while (end > start) { // 범위찾기
            long t = (start + end) / 2;

            if(isValid(t, n, times)) {
                end = t;
            } else {
                start = t + 1;
            }
        }

        return start;
    }

    private boolean isValid(long t, int n, int[] times) {
        long c = 0;

        for(int time : times) {
            c += t / time;
        }

        return c >= n;
    }
}
