package src.LeetCode.Graphs;

// https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i]){
                provinces++;
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int idx, int[][] isConnected, boolean[] visited) {
        visited[idx] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[idx][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }
}
