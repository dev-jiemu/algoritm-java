package src.LeetCode.Queue;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
public class Dota2Senate {
    // Radiant
    // Dire
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {
                radiant.add(rIndex + n);
            } else {
                dire.add(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
