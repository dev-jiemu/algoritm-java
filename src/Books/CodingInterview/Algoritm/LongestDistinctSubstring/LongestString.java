package src.Books.CodingInterview.Algoritm.LongestDistinctSubstring;

public class LongestString {

    private static final int ASCII_CODES = 256;
    
    // 슬라이딩 윈도 기법
    // Ref. https://ji-musclecode.tistory.com/37
    public static String longestDistinctSubstring(String str) {
        boolean[] flagWindow = new boolean[ASCII_CODES];
        
        int left = 0;
        int right = 0;
        
        for (int wl = 0, wr = 0; wr < str.length(); wr++) {
            if (flagWindow[str.charAt(wr)]) {
                while(str.charAt(wl) != str.charAt(wr)) {
                    flagWindow[str.charAt(wl)] = false;
                    wl++;
                }
                
                // 현재 문자 제거
                wr++;
            } else {
                // 존재하지 않는 문자 추가처리
                flagWindow[str.charAt(wr)] = true;

                // 창 크기 업데이트
                if((right - left) < (wr - wl)) {
                    left = wl;
                    right = wr;
                }
            }
        }

        return str.substring(left, right + 1);
    }
}
