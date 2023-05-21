package src.LinearSearch;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Scanner;

public class SequentialSearch {

    /*
    public static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while(true) {
            if(i == n) {
                return -1; // 검색 실패시
            }
            if(a[i] == key) {
                return i;
            }
            i++;
        }
    }
     */
    public static int seqSearch(int[] a, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Logger LOGGER = LoggerFactory.getLogger(SequentialSearch.class.getClass());

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 : ");

        int num = scanner.nextInt();
        int[] x = new int[num];

        for(int i = 0; i < num; i++) {
            LOGGER.debug("x[" + i + "] :");
            x[i] = scanner.nextInt();
        }

        System.out.println("검색할 값 : ");
        int key = scanner.nextInt();

        // 검색
        int result = seqSearch(x, num, key);

        if (result == -1 ) {
            System.out.println("검색 실패");
        } else {
            System.out.println("해당 인덱스: " + result);
        }
    }
}
