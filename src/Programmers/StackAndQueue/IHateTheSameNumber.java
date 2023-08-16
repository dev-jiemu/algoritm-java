package src.Programmers.StackAndQueue;

import java.util.*;

public class IHateTheSameNumber {
    public static int[] solution(int []arr) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();

        for (int item : arr) {
            queue.add(item);
        }

        Queue<Integer> unique = new LinkedList<>();

        Integer prev = null;

        while (!queue.isEmpty()) {
            int current = queue.peek();
            if (prev == null || prev != current) {
                unique.add(current);
            }
            prev = current;
            queue.remove();
        }


        answer = new int[unique.size()];

        int idx = 0;
        while(!unique.isEmpty()) {
            Integer value = unique.peek();
            answer[idx++] = value;
            unique.remove();
        }

        return answer;
    }

    public static void main(String[] args) {
        int []arr = new int[]{1,1,3,3,0,1,1};

        int[] result = solution(arr);

        for (int item : result) {
            System.out.println(item);
        }
    }
}
