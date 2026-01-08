package src.LeetCode.BFSandDFS;

import java.util.*;

// https://leetcode.com/problems/longest-special-path/description/
public class LongestSpecialPath {
    private int maxLength = 0;
    private int minNodes = 1;
    private List<int[]>[] graph;
    private int[] nums;

    // 경로 추적을 위한 자료구조
    private Map<Integer, Integer> lastDepthMap = new HashMap<>();
    private int[] distToDepth = new int[50005];

    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        this.nums = nums;
        int n = nums.length;
        if (n == 0) return new int[]{0, 0};

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        dfs(0, -1, 0, 0, 0);

        return new int[]{maxLength, minNodes};
    }

    /*
        depth=0, node=0, nums[0]=2: lastDepthMap={2:0}
          depth=1, node=1, nums[1]=1: lastDepthMap={2:0, 1:1}
            depth=2, node=2, nums[2]=2:
              - prevOccurrenceDepth=0 (숫자 2가 depth 0에 있었음)
              - newTopDepth=1 (depth 1부터 유효)
              - path: node 1→2, length=3, nodes=2

            depth=2, node=4, nums[4]=3:
              - path: node 1→4, length=4, nodes=2

            depth=2, node=3, nums[3]=1:
              - prevOccurrenceDepth=1 (숫자 1이 depth 1에 있었음)
              - newTopDepth=2 (현재 노드만)
              - path: single node, length=0, nodes=1
     */

    private void dfs(int node, int parent, int currentLength, int depth, int topDepth) {
        // 현재 숫자가 이전에 나왔던 깊이를 확인
        int prevOccurrenceDepth = lastDepthMap.getOrDefault(nums[node], -1);

        // 중복된 숫자가 있다면 그 숫자 다음 깊이부터만 유효함
        int newTopDepth = Math.max(topDepth, prevOccurrenceDepth + 1);

        // 현재 유효한 경로의 길이와 노드 수 계산
        int specialPathLen = currentLength - distToDepth[newTopDepth];
        int nodeCount = depth - newTopDepth + 1;

        if (specialPathLen > maxLength) {
            maxLength = specialPathLen;
            minNodes = nodeCount;
        } else if (specialPathLen == maxLength) {
            minNodes = Math.min(minNodes, nodeCount);
        }

        // backtracking
        int originalLastDepth = lastDepthMap.getOrDefault(nums[node], -1);
        lastDepthMap.put(nums[node], depth);
        distToDepth[depth + 1] = 0;

        for (int[] neighbor : graph[node]) {
            int nextNode = neighbor[0];
            int weight = neighbor[1];

            if (nextNode == parent) continue;

            distToDepth[depth + 1] = currentLength + weight;
            dfs(nextNode, node, currentLength + weight, depth + 1, newTopDepth);
        }

        if (originalLastDepth == -1) {
            lastDepthMap.remove(nums[node]);
        } else {
            lastDepthMap.put(nums[node], originalLastDepth);
        }
    }
}
