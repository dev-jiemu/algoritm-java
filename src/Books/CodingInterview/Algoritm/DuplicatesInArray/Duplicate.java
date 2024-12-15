package src.Books.CodingInterview.Algoritm.DuplicatesInArray;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

// 중복된 값이 있을때 true 리턴
public class Duplicate {

    // HashSet
    public static boolean checkDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                return true;
            }

            set.add(arr[i]);
        }

        // 이렇게도 축약 가능함
//        Set set = new HashSet<>(java.util.Arrays.asList(IntStream.of(arr).boxed().toArray(Integer[]::new)));
//        return arr.length != set.size();

        return false;
    }
    
    // IntStream 사용도 가능
    public static boolean checkDuplicateStream(int[] arr) {
        long distinctCount = IntStream.of(arr).boxed().distinct().count();

        return arr.length != distinctCount;
    }

    // 실행기간이 O(n) 일때 공간 복잡도를 O(1) 로 만들려면?
    // ==> 음수가 없을때, 범위가 [0, n-1] 일때 (n = arr.length)
    public static boolean checkDuplicateAbs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else if (arr[Math.abs(arr[i])] == 0) {
                arr[Math.abs(arr[i])] = -(arr.length-1);
            } else {
                return true;
            }
        }

        return false;
    }
}
