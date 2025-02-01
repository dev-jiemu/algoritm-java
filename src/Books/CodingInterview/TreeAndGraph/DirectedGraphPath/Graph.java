package src.Books.CodingInterview.TreeAndGraph.DirectedGraphPath;

import java.util.*;

public class Graph<T> {
    private final Map<T, List<T>> adjacencyList = new HashMap<>();


    public boolean isPath(T from, T to) {
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();

        visited.add(from);
        queue.add(from);

        while(!queue.isEmpty()) {
            T element = queue.poll();

            List<T> adjacents = adjacencyList.get(element);
            if (adjacents != null) {
                for(T t : adjacents) {
                    if (t != null && !visited.contains(t)) {
                        visited.add(t);
                        queue.add(t);

                        if (t.equals(to)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
