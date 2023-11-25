package src.Books.BinarySearch;

import java.util.*;
import java.util.function.Consumer;

// https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class RankSearch {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoreMap = buildScoresMap(info);


        int[] answer = new int[query.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = count(query[i], scoreMap);
        }

        return answer;
    }


    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoreMap = new HashMap<>(); // 검색조건 - 점수 list

        //[개발 언어, 직군, 경력, 소울푸드]
        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]); // 맨 마지막이 점수

            forEachKey(0, "", tokens, key -> {
                scoreMap.putIfAbsent(key, new ArrayList<>());
                scoreMap.get(key).add(score);
            });
        }

        // 리스트 정렬
        for (List<Integer> list : scoreMap.values()) {
            Collections.sort(list);
        }

        return scoreMap;
    }

    // 재귀탐색
    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        if (index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

    // counting
    private int count(String query, Map<String, List<Integer>> scoreMap) {
        String[] tokens = query.split(" (and )?"); // 공백 또는 and로 구분
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1)); // 배열을 새로 생성하고 복사하므로 성능자체는 별로...

        if (!scoreMap.containsKey(key)) return 0;

        List<Integer> scores = scoreMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scoreMap.get(key));
    }

    // 이진검색
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (scores.get(start) < score) {
            return scores.size();
        }

        return start;
    }
}
