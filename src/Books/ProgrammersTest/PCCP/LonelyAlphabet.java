package src.Books.ProgrammersTest.PCCP;

// https://school.programmers.co.kr/learn/courses/15008/lessons/121683
public class LonelyAlphabet {
    public String Solution(String input_string) {
        input_string = "." + input_string + ".";

        StringBuilder builder = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++) {
            if (input_string.split(c + "+").length < 3) {
                continue;
            }
            builder.append(c);
        }

        if (builder.length() == 0) {
            return "N";
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        LonelyAlphabet lonelyAlphabet = new LonelyAlphabet();
        String input_string = "edeaaabbccd";
        String result = lonelyAlphabet.Solution(input_string);

        System.out.println("result: " + result);
    }
}
