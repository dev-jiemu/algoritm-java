package src.Recursion.EightQueen;

// 분기 한정법
public class QueenBB {
    static boolean[] flag = new boolean[8]; // 퀸 배치 했는지 확인
    static int[] pos = new int[8]; // 각 열에 있는 퀸의 위치

    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    // i열의 알맞은 위치에 퀸을 배치
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag[j] == false) {
                pos[i] = j;
                if (i == 7) {
                    print();
                } else {
                    flag[j] = true;
                    set(i + 1);
                    flag[j] = false;
                }
            }
        }
    }

}
