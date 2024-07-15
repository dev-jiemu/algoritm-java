package src.Books.CodingInterview.Algoritm.ShrinkerString;

// abbb vvvv s rttt
// => a1b3 b4 s1 r1t3
public class Strings {
    public static String shrink(String str) {
        StringBuffer result = new StringBuffer();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            
            if(!Character.isWhitespace(str.charAt(i))) { // 공백은 세지 말고
                // 더이상 셀 문자가 없거나, 다음 문자가 다를때
                if((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                    result.append(str.charAt(i)).append(count);
                    count = 0;
                }
            } else {
                result.append(str.charAt(i));
                count = 0;
            }
        }

        return result.length() > str.length() ? str : result.toString(); // 결과 문자열이 더 짧을때 리턴
    }
}
