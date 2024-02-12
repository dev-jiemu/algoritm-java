package src.Books.ProgrammersTest.Strings;

public class FlipOverNatureNumbers {
    public int[] solution(long n) {
        int[] answer = {};

        //String str = String.valueOf(n);
        String str = Long.toString(n);
        answer = new int[str.length()];

//        int j = 0;
//        for (int i = str.length() - 1; i >= 0; i--) {
//            answer[j] = str.charAt(i) - '0';
//            j++;
//        }

        String reversed = new StringBuffer(str).reverse().toString();
        char[] arr = reversed.toCharArray();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[i] - '0';
        }

        return answer;
    }

}
