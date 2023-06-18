package src.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("요소수: ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");
        System.out.println("x[0]: ");
        x[0] = scanner.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.println("x[" + i + "] : ");
                x[i] = scanner.nextInt();
            } while (x[i] < x[i-1]);
        }

        System.out.println("검색할 값: ");
        int ky = scanner.nextInt();

        // Util.Arrays
        int idx = Arrays.binarySearch(x, ky);

        if (idx < 0) {
            System.out.println("존재하지 않습니다");
        } else {
            System.out.println("그 값은 x[" + idx + "] 에 있습니다");
        }

    }
}
