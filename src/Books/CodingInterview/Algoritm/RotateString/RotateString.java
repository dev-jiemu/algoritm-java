package src.Books.CodingInterview.Algoritm.RotateString;

import java.util.regex.Pattern;

public class RotateString {
    // str1 + str2 = (p1 + p2) + (p2 + p1)
    private static boolean isRotation(String str1, String str2) {
        return (str1 + str2).matches("(?i).*" + Pattern.quote(str2) + ".*");
    }
}
