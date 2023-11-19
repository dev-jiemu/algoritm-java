package src.Programmers.Greedy;

import java.util.*;

public class GymSuit {

    // https://school.programmers.co.kr/learn/courses/14743/lessons/118024
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        // 배열을 리스트로 변환
        for (int num : lost) {
            lostList.add(num);
        }

        for (int num : reserve) {
            reserveList.add(num);
        }

        // 중복된 요소 제거
        // 여분의 체육복이 있는 사람이 잃어버릴 수도 았음에 유의
        Iterator<Integer> iterator = reserveList.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (lostList.contains(num)) {
                lostList.remove(num);
                iterator.remove(); // Iterator를 사용하여 안전하게 제거
            }
        }

        answer = n - lostList.size();

        for (int i = 0; i < lostList.size(); i++) {
            for (int j = 0; j < reserveList.size(); j++) {
                int reserveItem = reserveList.get(j);
                if (isReservable(lostList.get(i), reserveItem, n)) {
                    answer++;
                    reserveList.remove(j); // 여벌 체육복을 빌렸으므로 reserveList에서 제거
                    break;
                }
            }
        }

        return answer;
    }

    public boolean isReservable(int lostPosition, int reservePosition, int totalStudents) {
        return (lostPosition == 1 && lostPosition + 1 == reservePosition) ||
                (lostPosition == totalStudents && lostPosition - 1 == reservePosition) ||
                (lostPosition + 1 == reservePosition) ||
                (lostPosition - 1 == reservePosition);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{1, 3, 5};

        GymSuit gymSuit = new GymSuit();
        int result = gymSuit.solution(n, lost, reserve);

        System.out.println("result : " + result);
    }
}
