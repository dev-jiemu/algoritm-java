package src.Programmers.FullSearch;


import java.util.*;

class Counting {
    public int index;
    public int count;

    public Counting(int index) {
        this.index = index;
        this.count = 0;
    }
}

public class MockExam {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] people1 = new int[]{1, 2, 3, 4, 5};
        int[] people2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] people3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Counting people1_count = new Counting(1);
        Counting people2_count = new Counting(2);
        Counting people3_count = new Counting(3);



        for (int i = 0; i < answers.length; i++) {
            if (people1[i % people1.length] == answers[i]) {
                people1_count.count++;
            }
            if (people2[i % people2.length] == answers[i]) {
                people2_count.count++;
            }
            if (people3[i % people3.length] == answers[i]) {
                people3_count.count++;
            }
        }

        ArrayList<Counting> countingList = new ArrayList<>();
        countingList.add(people1_count);
        countingList.add(people2_count);
        countingList.add(people3_count);

        // 가장 큰 count 찾기
        int maxCount = Integer.MIN_VALUE;
        for (Counting counting : countingList) {
            maxCount = Math.max(maxCount, counting.count);
        }

        ArrayList<Integer> maxIndexList = new ArrayList<>();
        for (Counting counting : countingList) {
            if (counting.count == maxCount) {
                maxIndexList.add(counting.index);
            }
        }

        // maxIndexList 오름차순으로 정렬
        Collections.sort(maxIndexList);

        answer = new int[maxIndexList.size()];
        for(int i = 0; i < maxIndexList.size(); i++) {
            answer[i] = maxIndexList.get(i);
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] answer = new int[]{1, 3, 2, 4, 2};

        MockExam mockExam = new MockExam();

        int[] result = mockExam.solution(answer);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
