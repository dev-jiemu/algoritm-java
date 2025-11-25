package src.LeetCode.BFSandDFS;

// https://leetcode.com/problems/water-and-jug-problem/description/?envType=problem-list-v2&envId=breadth-first-search
public class WaterandJugProblem {
    // 최대공약수
    // 양수면 채우는거고, 음수면 비우는거임
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) {
            return false;
        }

        if (target == 0 || x == target || y == target || (x + y) == target) {
            return true;
        }

        // 최대공약수
        int gcd = gcd(x, y);

        return target % gcd == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
