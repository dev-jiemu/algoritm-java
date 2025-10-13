package src.Books.CodingInterview.Algoritm.RadixSort;

// 14. 기수정렬
// 1의 자리부터 마지막 자리까지 정렬
public class RadixSort {
    public void sort(int[] arr, int radix) {
        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int exp = 1;
        while ((max - min) / exp >= 1) {
            countSortByDigit(arr, radix, exp, min);
            exp *= radix;
        }
    }

    private void countSortByDigit(int[] arr, int radix, int exp, int min) {
        int[] buckets = new int[radix];
        for(int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }

        int bucket = 0;
        for(int i = 0; i < arr.length; i++) {
            bucket = (int)(((arr[i] - min) / exp) % radix);
            buckets[bucket]++;
        }

        for(int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        int[] out = new int[arr.length];
        for(int i = arr.length; i >= 0; i--) {
            bucket = (int) (((arr[i] - min) / exp) % radix);
            out[--buckets[bucket]] = arr[i];
        }

        System.arraycopy(out, 0, arr, 0, arr.length);
    }
}
