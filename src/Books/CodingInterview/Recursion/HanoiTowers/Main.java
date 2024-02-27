package src.Books.CodingInterview.Recursion.HanoiTowers;

public class Main {
    public static void main(String[] args) {
        int n = 3;  // Number of disks

        // 원점, 대상, 중간 막대 순
        Hanoi.moveDisks(n, 'A', 'C', 'B');
    }
}
