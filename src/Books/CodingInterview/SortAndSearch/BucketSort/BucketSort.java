package src.Books.CodingInterview.SortAndSearch.BucketSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    // 버킷 생성하는 과정 O(n)
    // 생성한 버킷에 데이터 넣는 과정 O(m)
    // => O(n + m)
    public static void sort1(int[] arr) {
        int[] hashes = hash(arr);

        // 버킷 생성
        List<Integer>[] buckets = new List[hashes[1]];
        for(int i = 0; i < hashes[1]; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int e : arr) {
            buckets[hash(e, hashes)].add(e);
        }

        for(List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int p = 0;
        for(List<Integer> bucket : buckets) {
            for(int j : bucket) {
                arr[p++] = j;
            }
        }
    }

    // 분산 - 정렬
    public static void sort2(int[] arr) {
        int max = arr[0]; // 최대값
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int[] bucket = new int[max + 1]; // 최대버킷

//        for(int i = 0; i < bucket.length; i++) {
//            bucket[i] = 0;
//        }

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int p = 0;
        for(int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[p++] = i;
            }
        }

    }

    private static int[] hash(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (m < arr[i]) {
                m = arr[i];
            }
        }

        return new int[]{m, (int) Math.sqrt(arr.length)};
    }

    private static int hash(int num, int[] hashes) {
        return (int) ((double) num / hashes[0] * (hashes[1] - 1));
    }

}
