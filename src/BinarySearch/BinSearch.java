package src.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 이진탐색은 데이터가 사전에 정렬(sort)되었음을 전제로 함
public class BinSearch {
    static int binSearch(int[] a, int n, int key) {
        int pl = 0; // 첫 인덱스
        int pr = n - 1; // 끝 인덱스

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                return pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1; // 검색실패
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("요소수 : ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        System.out.println("배열을 입력하세요.");
        System.out.println("x[0] : ");
        x[0] = scanner.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.println("x[" + i + "] : ");
                x[i] = scanner.nextInt();
            } while (x[i] < x[i-1]);
        }

        Arrays.sort(x); // 오름차순으로 정렬

        System.out.println("찾을 값 : ");
        int key = scanner.nextInt();

        int idx = binSearch(x, num, key);

        if (idx == -1) {
            System.out.println("존재하지 않습니다");
        } else {
            System.out.println("그 값은 x[" + idx + "] 에 있습니다");
        }
    }
}
