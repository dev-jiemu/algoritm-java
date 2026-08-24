package src.LeetCode.BFSandDFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 3493. Properties Graph
// https://leetcode.com/problems/properties-graph/description/
// DFS 로 풀면?
public class PropertiesGraphDFS {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;

        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(this.intersect(properties[i], properties[j]) >= k) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                this.dfs(i, graph, visited);
                count++;
            }
        }

        return count;
    }

    // dfs
    private void dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }

    // 겹치는거 찾기
    private int intersect(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int x : a) {
            setA.add(x);
        }

        Set<Integer> setB = new HashSet<>();
        for (int x : b) {
            setB.add(x);
        }

        setA.retainAll(setB); // setA에 setB랑 겹치는 것만 남김
        return setA.size();
    }
}
