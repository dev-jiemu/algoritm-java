package src.LeetCode.BFSandDFS;

import java.util.HashSet;
import java.util.Set;

// 3493. Properties Graph
// https://leetcode.com/problems/properties-graph/description/
public class PropertiesGraph {
    private int[] parent;

    // Union-Find (Disjoint Set Union)
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;

        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 일단 자기 자신으로 초기화
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(this.intersect(properties[i],properties[j]) >= k) {
                    union(i, j);
                }
            }
        }

        // 중복체크
        HashSet<Integer> roots = new HashSet<>();
        for(int i = 0; i < n; i++){
            roots.add(find(i));
        }

        return roots.size();
    }

    private int find(int x) {
        if (this.parent[x] != x) {
            this.parent[x] = this.find(this.parent[x]); // 여기! 대입까지 해야 경로 압축이 됨
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            this.parent[rootX] = rootY;
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
