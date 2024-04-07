package src.Books.CodingInterview.Recursion.Coins;

// 동전 거스름돈
// 메모이제이션(중복계산 방지)
public class Coins {

    // 메모이제이션 안썼을때
    public static int calculateChange(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] coins = {25, 10, 5, 1};
        return calculateChange(n, coins, 0);
    }

    private static int calculateChange(int amount, int[] coins, int position) {
        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;

        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChange(remaining, coins, position + 1);
        }

        return count;
    }

    // 메모이제이션 썼을때
    public static int calculateChangeMemoization(int n) {
        int[] coins = {25, 10, 5, 1};
        int[][] cache = new int[n + 1][coins.length];

        return calculateChangeMemoization(n, coins, 0, cache);
    }

    private static int calculateChangeMemoization(int amount, int[] coins, int position, int[][] cache) {
        if(cache[amount][position] > 0){ // 0보다 큰값이 있으면 계산된거임 = 리턴하고 종료
            return cache[amount][position];
        }

        if (position >= coins.length - 1) { // 포지션이 coin 개수를 넘어가면
            return 1;
        }

        int coin = coins[position];
        int count = 0;
        for(int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChangeMemoization(remaining, coins, position + 1, cache);
        }

        cache[amount][position] = count; // 메모이제이션 처리
        return count;
    }

}
