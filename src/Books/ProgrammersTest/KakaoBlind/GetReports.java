package src.Books.ProgrammersTest.KakaoBlind;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class GetReports {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        for (String id : id_list) {
            reports.put(id, new HashSet<>());
        }

        // 신고당한 유저 횟수 체크
        Map<String, Integer> reported = new HashMap<>();

        for (String r : report) {
            String[] tokens = r.split(" ");
            String reporter = tokens[0]; // 신고 접수 한 사람
            String target = tokens[1]; // 신고한 사람

            // reporter와 target이 이미 있는 경우는 무시해야 함
            Set<String> set = reports.get(reporter);
            if (!set.contains(target)) {
                set.add(target);
                reported.putIfAbsent(target, 0);
                reported.put(target, reported.get(target) + 1);
            }
        }

        // 정지대상 리스트
        Set<String> banned = reported.keySet().stream().filter(id -> reported.get(id) >= k).collect(Collectors.toSet());

        return Arrays.stream(id_list).mapToInt(id -> (int) reports.get(id).stream().filter(banned::contains).count()).toArray();
    }
}
