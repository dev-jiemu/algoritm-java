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
}
