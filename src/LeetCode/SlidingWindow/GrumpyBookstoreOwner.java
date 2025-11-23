package src.LeetCode.SlidingWindow;

// https://leetcode.com/problems/grumpy-bookstore-owner/?envType=problem-list-v2&envId=sliding-window
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i]; // 기분 좋을때 일단 다 구함
            }
        }

        // 초기 extra 계산
        int extra = 0;
        for(int i = 0; i < minutes; i++) {
            if(grumpy[i] == 1) {
                extra += customers[i];
            }
        }
        int maxExtra = extra;


        for(int i = minutes; i < customers.length; i++) {
            if(grumpy[i] == 1) {
                extra += customers[i];
            }

            if(grumpy[i - minutes] == 1) { // 윈도우에 해당 안되는거는 뺌
                extra -= customers[i - minutes];
            }
            maxExtra = Math.max(maxExtra, extra);
        }

        return satisfied + maxExtra;
    }
}
