package src.Books.CodingInterview.Recursion.HanoiTowers;

public class Hanoi {




    public static void moveDisks(int n, char origin, char target, char intermediate) {
        if (n <= 0) {
            return;
        }

        if (n == 1) {
            System.out.println("Move disk 1 from rod " + origin + " to rod " + target);
            return;
        }

        // 상위 n - 1개의 원반을 원점 막대에서 중간 막대로 옮김
        moveDisks(n - 1, origin, intermediate, target);

        System.out.println("Move disk " + n + " from rod " + origin + " to rod " + target);

        // 상위 n - 1개의 원반을 중간 막대에서 대상 막대로 옮김
        moveDisks(n - 1, intermediate, target, origin);
    }
}
