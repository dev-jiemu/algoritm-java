package src.Books.CodingInterview.Algoritm.UniqueCharacters;

import java.util.HashMap;
import java.util.Map;

public class UniqueStrings {
    // 고유문자만 구성되어있으면 true return
    private static final int MAX_CODE = 65535;

    public static boolean isUnique(String str) {
        if (str == null || str.isEmpty()) {
            // throws IllegalArgumentException
            return false;
        }

        Map<Character, Boolean> chars = new HashMap<>();

        /*
        for (char ch : str.toCharArray()) {
            if (ch <= MAX_CODE) {
                if (!Character.isWhitespace(ch)) {
                    if (chars.put(ch, true) != null) {
                        return false;
                    }
                }
            } else {
                System.out.println("The given string contains unallowed characters");
                return false;
            }
        }
         */
        for (char ch : str.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                if (chars.put(ch, true) != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
