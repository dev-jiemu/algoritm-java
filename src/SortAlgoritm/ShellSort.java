package src.SortAlgoritm;

// 셸정렬 : 4그룹으로 나눠서 정렬 -> 2그룹으로 나눠서 정렬 -> 순차정렬 순
public class ShellSort {
    static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) { // 지정한 n의 값을 반절씩 쪼개면서 for문 실행
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for(j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
    }

    // h값을 반으로 나누기만 하면 그룹끼리 정렬되지 않음 :: 서로 배수가 되지 않도록 해야함
    static void shellSort2(int[] a, int n) {
        int h;
        for (h = 1; h < n; h= h * 3 + 1) // 1부터 시작해서 3배 곱하고 1더한 값 < n인 범위까지
            ;

        for ( ; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
    }
}
