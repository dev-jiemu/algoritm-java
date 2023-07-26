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
}
