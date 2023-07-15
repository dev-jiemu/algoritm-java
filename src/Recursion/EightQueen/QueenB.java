package src.Recursion.EightQueen;


// 일단 모든 조합만 계산해봄
public class QueenB {
    static int[] pos = new int[8];

    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }


    // i열에 퀸을 배치함
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            pos[i] = j;
            if (i == 7){
                print();
            } else {
                set(i + 1); // 다음열에 배치
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
