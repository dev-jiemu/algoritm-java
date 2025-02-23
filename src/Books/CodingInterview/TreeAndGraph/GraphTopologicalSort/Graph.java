package src.Books.CodingInterview.TreeAndGraph.GraphTopologicalSort;

import java.util.*;

public class Graph<T> {
    private final Map<T, List<T>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // 너비 우선 탐색 또는 깊이 우선 탐색 알고리즘으로 그래프를 순회할수는 있는데...
    // Stack을 활용해서 정점의 모든 이웃을 다 순회부터 하고, 해당 정점을 push 하는 방법으로 해결 가능 ㅇㅂㅇ
    public Stack<T> topologicalSort(T startElement) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        topologicalSort(startElement, visited, stack);

        return stack;
    }

    private void topologicalSort(T currentElement, Set<T> visited, Stack<T> stack) {
        visited.add(currentElement);
        List<T> adjacents = adjacencyList.get(currentElement);

        if (adjacents != null) {
            for (T t : adjacents) {
                if (t != null && !visited.contains(t)) {
                    topologicalSort(t, visited, stack);
                    visited.add(t);
                }
            }
        }

        stack.push(currentElement);
    }
}
