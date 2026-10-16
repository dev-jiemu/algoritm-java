package src.LeetCode.BFSandDFS;

import java.util.*;

// 3607. Power Grid Maintenance
// https://leetcode.com/problems/power-grid-maintenance/description/
public class PowerGridMaintenance {
    private int[] parent;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
        }

        // 1. 그래프 만들기
        for(int[] conn : connections){
            union(conn[0], conn[1]);
        }

        // 2. 묶음별 발전소 정리
        Map<Integer, TreeSet<Integer>> group = new HashMap<>();
        for(int i = 1; i <= c; i++){
            int root = find(i);
            group.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // 3. 쿼리하기
        for(int[] query : queries){
            int first = query[0];
            int second = query[1];

            // 온라인만 남음에 주의
            TreeSet<Integer> set = group.get(find(second));

            if (first == 1) {
                if (set.contains(second)) {
                    result.add(second);
                } else if (!set.isEmpty()) {
                    result.add(set.first());
                } else {
                    result.add(-1); // 오프라인
                }
            } else {
                set.remove(second);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] != x) {
           parent[x] = find(parent[x]); // 경로 압축
        }

        return parent[x];
    }

    private void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a != b) {
            parent[b] = a;
        }
    }
}
