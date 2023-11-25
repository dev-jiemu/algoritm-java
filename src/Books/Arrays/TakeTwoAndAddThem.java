package src.Books.Arrays;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class TakeTwoAndAddThem {
    public int[] solution(int[] numbers) {
        // 모든 정수를 중복 없이 만들어서 정렬
        // HashSet
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i<numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
