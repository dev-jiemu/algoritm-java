package src.Books.ProgrammersTest.Hash;

import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/120888
public class RemoveDuplicateCharacters {
    public String solution(String my_string) {
        // 중복제거 Hash
        Set<Character> used = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (used.contains(c)) {
                continue;
            }
            used.add(c);
            builder.append(c);
        }

        return builder.toString();
    }
}
