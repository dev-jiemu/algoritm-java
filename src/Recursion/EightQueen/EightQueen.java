package src.Recursion.EightQueen;


// 8퀸 문제
// 규칙 1. 각 열에 퀸을 1개만 배치한다
// 규칙 2. 각 행에 퀸을 1개만 배치한다
// 규칙 3. 대각선으로 배치할 수 없다
public class EightQueen {
    static boolean[] flag_a = new boolean[8];
    // 대각선으로 배치했는지 확인
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int[] pos = new int[8];

    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false) { // 가로, 대각선으로 퀸이 배치안되어있으면 배치
                pos[i] = j;
            }
            if (i == 7) {
                print();
            } else {
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                set(i + 1);
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }

}
