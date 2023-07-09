package src.Recursion;

import java.util.Scanner;

// 재귀 : 하노이의 탑
public class TowersOfHanoi {
    // no: 옯겨야 할 쟁반 개수, x: 시작 기동의 번호, y: 목표 기둥의 번호
    static void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y); // 시작 기둥에서 중간 기둥으로 이동
        }

        System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y);

        if (no > 1) {
            move(no - 1, 6 - x - y, y); // 중간 기둥에서 목표 기둥으로 이동
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("원반의 개수 : ");
        int n = scanner.nextInt();

        move(n, 1, 3);
    }
}
