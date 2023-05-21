package src.LinearSearch;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Scanner;

// 보초 공간에 검색하고자 하는 데이터를 집어넣음
public class SequentialSearchSentinel {

    public static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;

        while(true) {
            if (a[i] == key) {
                break;
            }
            i++;
        }

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Logger LOGGER = LoggerFactory.getLogger(SequentialSearchSentinel.class.getClass());

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 : ");

        int num = scanner.nextInt();
        int[] x = new int[num + 1]; // 보초 데이터 들어갈 공간까지 확보

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
