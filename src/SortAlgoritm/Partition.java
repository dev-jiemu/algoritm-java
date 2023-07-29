package src.SortAlgoritm;

// 퀵 정렬
// 기준점을 정해서 기준점보다 낮은데이터, 높은데이터를 찾아 정렬함
public class Partition {
    static void Swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void partition(int[] a, int n) {
        int pl = 0;
        int pr = n - 1;
        // 피벗을 가운데로 지정했지만 어디를 피벗으로 잡느냐에 따라 성능에 영향을 미침
        int x = a[n / 2]; // 가운데

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr --;
            if (pl <= pr) {
                Swap(a, pl++, pr--);
            }
        } while (pl <= pr);
    }
}
