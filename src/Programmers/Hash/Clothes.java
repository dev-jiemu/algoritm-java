package src.Programmers.Hash;

import java.util.HashMap;

public class Clothes {

    //[의상의 이름][의상의 종류]
    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        // 아무것도 안 입을수도 있어서 +1
        for (Integer integer : map.values()) {
            answer *= integer + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int result = solution(clothes);

        System.out.println("result : " + result);
    }
}
