package src.Programmers.Hash;

import java.util.HashMap;
import java.util.Map;

public class NotFinished {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String comp : completion) {
            if (map.containsKey(comp)) {
                map.put(comp, map.get(comp) - 1);
            }
        }

        for( String strKey : map.keySet() ){
            int strValue = map.get(strKey);
            if (strValue > 0) {
                answer = strKey;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        String result = solution(participant, completion);

        System.out.println("result : " + result);
    }
}
