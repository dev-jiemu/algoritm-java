package src.Books.CodingInterview.Algoritm.OneEditAway;

import java.util.HashMap;

public class Strings {
    // q, p 가 있을때 하나만 바꾸면 동일한 문자열인지 확인하는 코드
    // 삽입, 제거, 변경 다 가능함
    public static boolean isOneEditAway(String q, String p) {
        // length 자체 차이가 1 이상이라면 2개 이상 차이나는거지...
        if (Math.abs(q.length() - p.length()) > 1) {
            return false;
        }

        String shorter = q.length() < p.length() ? q : p;
        String longer = q.length() < p.length() ? p : q;

        int is = 0;
        int il = 0;
        boolean marker = false;

        while(is < shorter.length() && il < longer.length()) {
            if (shorter.charAt(is) != longer.charAt(il)) { // 같은 문자인지 아닌지 비교
                if (marker) { // 차이점 이미 찾았는데 또 있다면 false
                    return false;
                }

                marker = true;

                if (shorter.length() == longer.length()) {
                    is++;
                }
            } else { // 같은 문자면 그 다음 문자 체크
                is++;
            }

            il++; // longer의 다음 index로 이동
        }

        return true;
    }

    // longer 문자열 HashMap 에 한글자씩 넣고 shorter 문자열 하나씩 빼도 되지않나?
    public static boolean isOneEditAwayWithHashMap(String q, String p) {
        HashMap<Character, Integer> Longer = new HashMap<>();

        if (Math.abs(p.length() - q.length()) > 1) {
            return false;
        }

        String shorter = q.length() < p.length() ? q : p;
        String longer = q.length() < p.length() ? p : q;

        for (char c : longer.toCharArray()) {
            Longer.put(c, Longer.getOrDefault(c, 0) + 1);
        }

        for (char c : shorter.toCharArray()) {
            int count = Longer.getOrDefault(c, 0);

            if (count == 0) {
                // 없는 문자열이라 차이점이 생기는거임
                Longer.put(c, -1);
            } else {
                // 있는 문자열이라 하나 뺌
                Longer.put(c, count - 1);
            }
        }

        int diff = 0;
        for (int count : Longer.values()) {
            diff += Math.abs(count);
        }

        System.out.println("diff : " + diff);
        if (diff > 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String q = "testo";
        String p = "testoa";

        // System.out.println("result : " + Strings.isOneEditAway(p, q));
        System.out.println("result : " + Strings.isOneEditAwayWithHashMap(p, q));
    }
}
