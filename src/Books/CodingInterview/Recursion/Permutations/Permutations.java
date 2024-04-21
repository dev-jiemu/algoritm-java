package src.Books.CodingInterview.Recursion.Permutations;

import java.util.*;
import java.util.function.BiFunction;

public class Permutations {

//    public static Set<String> permute(String str) {
//        return permute("", str);
//    }

    // 해당 코드는 중복을 고려하지 않았음.
    // 정확히는 Set은 중복을 허용하지 않으니까 결과 자체는 중복이 없지만 계산 자체를 중복적으로 하니까 효율성이 떨어지는편임.
    public static Set<String> permute(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();

        for(int i = 0; i < n; i++) {
            permutations.addAll(permute(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
        }

        return permutations;
    }

    // ---------------------------
    // 중복 고려까지 된 케이스
    public static List<String> permute(String str) {
        return permute("", str.length(), charactersMap(str));
    }

    private static Map<Character, Integer> charactersMap(String str) {
        Map<Character, Integer> characters = new HashMap<>();
        BiFunction<Character, Integer, Integer> count = (key, value) -> ((value == null) ? 1 : ++value); // 몇번 나오는지 체크

        for (char c : str.toCharArray()) {
            characters.compute(c, count);
        }

        return characters;
    }

    public static List<String> permute(String prefix, int strlength, Map<Character, Integer> characters) {
        List<String> permutations = new ArrayList<>();

        for (Character c : characters.keySet()) {
            int count = characters.get(c);

            if (count > 0) {
                characters.put(c, count - 1);
                permutations.addAll(permute(prefix + c, strlength - 1, characters));
                characters.put(c, count);
            }
        }

        return permutations;
    }
}
