package src.SortAlgoritm;

import src.Stack.IntStack;

public class QuickSort {
    static void swap(int[] a, int idx1, int idx2) {
        int i = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = i;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pr + pr) / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr --;
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

    static void quickSortNotRecursion(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true){
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr --;
                if (pl <= pr) {
                    swap(a, pl++, pr--);
                }
            } while (pl <= pr);

            if (left < pr) { // 왼쪽그룹
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) { // 오른쪽그룹
                lstack.push(pl);
                rstack.push(right);
            }

        }
    }

    // 가운데값 인덱스 반환
    static int sort3elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a]) swap(x, b, a);
        if (x[c] < x[b]) swap(x, c, b);
        if (x[b] < x[a]) swap(x, b, a);

        return b;
    }

    // 시간복잡도 : O(n log n) ~ O(n2)
    static void quickSort3rd(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int m = sort3elem(a, pl, (pl + pr) / 2, pr); // 처음, 가운데, 끝
        int x = a[m];

        swap(a, m, right - 1);
        pl++;
        pr -= 2; // 오른쪽 커서를 왼쪽으로 2만큼 옮김

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) {
                swap(a, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

}
