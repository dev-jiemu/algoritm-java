package src.Books.CodingInterview.Algoritm.CountScore3510;

public class Scores {

    // 동적 프로그래밍
    public static int count(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;

        for(int i = 3; i <= n; i++) {
            table[i] += table[i - 3];
        }

        for(int i = 5; i <= n; i++) {
            table[i] += table[i - 5];
        }

        for(int i = 10; i <= n; i++) {
            table[i] += table[i - 10];
        }

        return table[n];
    }
}
