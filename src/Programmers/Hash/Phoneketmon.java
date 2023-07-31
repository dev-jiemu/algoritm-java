package src.Programmers.Hash;

import java.util.HashMap;

// 폰켓몬
public class Phoneketmon {

    public static int solution(int[] nums) {
        int answer = 0;
        int maxSize = nums.length / 2; // 반절만 골라야 함

        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for (int num : nums) {
            if (!resultMap.containsKey(num)) {
                resultMap.put(num, num); // 모든 경우의 수를 다 계산해봄
            }
        }

        // 실 경우의 수가 maxSize가 작을 때만 hashmap size 리턴
        answer = resultMap.size() < maxSize ? resultMap.size() : maxSize;

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 3};
        int result = solution(nums);

        System.out.println("result : " + result);
    }

}
