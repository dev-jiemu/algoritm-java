package src.Books.CodingInterview.Algoritm.LongestConsecutiveSequence;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sequence {
    // 단순하게 배열 정렬해서 계산하는 방법 = O(nlogn)
    // 해시를 이용하면 o(n)
    public static int findLongestConsecutive(int[] sequence) {
        int result = 1;

        Set<Integer> sequenceSet = IntStream.of(sequence).boxed().collect(Collectors.toSet());

        for (int elem : sequence) {
            if(!sequenceSet.contains(elem - 1)) {
                int sequenceLength = 1;

                while (sequenceSet.contains(elem + sequenceLength)) { // elem - 1 으로부터 시작해서 1개씩 늘려서 찾음
                    sequenceLength++;
                }

                result = Math.max(result, sequenceLength); // 가장 큰 값
            }
        }

        return result;
    }
}
