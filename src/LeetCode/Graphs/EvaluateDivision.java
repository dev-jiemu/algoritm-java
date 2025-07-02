package src.LeetCode.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/evaluate-division/?envType=study-plan-v2&envId=leetcode-75
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];

        // graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, value);
            graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, 1.0 / value);
        }

        for (int j = 0; j < queries.size(); j++) {
            String start = queries.get(j).get(0);
            String end = queries.get(j).get(1);

            // start = end
            if (start.equals(end)) {
                if (graph.containsKey(start)) {
                    result[j] = 1.0;
                } else {
                    result[j] = -1.0;
                }

                continue;
            }

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[j] = -1.0;
                continue;
            }

            HashSet<String> visited = new HashSet<>();
            result[j] = dfs(graph, start, end, visited);
        }

        return result;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> graph, String start, String target, HashSet<String> visited) {
        if (start.equals(target)) {
            return 1.0;
        }

        visited.add(start);

        for (String neighbor : graph.get(start).keySet()) {
            if (!visited.contains(neighbor)) {
                double weight = graph.get(start).get(neighbor);
                double result = dfs(graph, neighbor, target, visited);
                if (result != -1.0) {
                    return weight * result;
                }
            }
        }

        return -1.0;
    }
}
