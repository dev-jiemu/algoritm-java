package src.Programmers.Practice.Lv1;

import java.util.HashMap;

// 가장 많이 받은 선물
// https://school.programmers.co.kr/learn/courses/30/lessons/258712
public class GiftTracker {

    // 본인의 선물지수 계산해야함(내가 준거 - 내가 받은거) -> 이건 나중에 동률일때 해도될듯
    public int solution(String[] friends, String[] gifts) {
        // 선물 기록용
        HashMap<String, HashMap<String, Integer>> giftHistory = new HashMap<>();

        // 선물을 준 횟수 (선물지수 계산용)
        HashMap<String, Integer> givenGifts = new HashMap<>();

        // 선물을 받은 횟수 (선물지수 계산용)
        HashMap<String, Integer> receiveGifts = new HashMap<>();

        // 다음 달에 받을 선물 개수
        int[] nextMonthGifts = new int[friends.length];

        for(String friend : friends) {
            giftHistory.put(friend, new HashMap<>());
            givenGifts.put(friend, 0);
            receiveGifts.put(friend, 0);
        }

        for (String gift : gifts) {
            // 0 준사람, 1 받은사람
            String[] giftSplit = gift.split(" ");
            String giver = giftSplit[0];
            String receiver = giftSplit[1];

            HashMap<String, Integer> history = giftHistory.get(giver);
            history.put(receiver, history.getOrDefault(receiver, 0) + 1);

            givenGifts.put(giver, givenGifts.get(giver) + 1);
            receiveGifts.put(receiver, receiveGifts.get(receiver) + 1);
        }

        // 대각선으로만 비교(A, B 비교했는데 B, A 한번 더 할 필요는 없으니까)
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String friend1 = friends[i];
                String friend2 = friends[j];

                int friend1ToFriend2 = giftHistory.get(friend1).getOrDefault(friend2, 0);
                int friend2ToFriend1 = giftHistory.get(friend2).getOrDefault(friend1, 0);

                if (friend1ToFriend2 > friend2ToFriend1) {
                    nextMonthGifts[i]++;
                } else if (friend2ToFriend1 > friend1ToFriend2) {
                    nextMonthGifts[j]++;
                } else { // 주고받은 선물 수가 같으면 선물 지수로 비교
                    int giftIndex1 = givenGifts.get(friend1) - receiveGifts.get(friend1);
                    int giftIndex2 = givenGifts.get(friend2) - receiveGifts.get(friend2);

                    if (giftIndex1 > giftIndex2) {
                        nextMonthGifts[i]++;
                    } else if (giftIndex2 > giftIndex1) {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }

        int maxGifts = 0;
        for (int count : nextMonthGifts) {
            maxGifts = Math.max(maxGifts, count);
        }

        return maxGifts;
    }
}
