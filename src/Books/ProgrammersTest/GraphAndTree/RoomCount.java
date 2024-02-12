package src.Books.ProgrammersTest.GraphAndTree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/49190
public class RoomCount {
    private static class Vertex {
        public final int x;
        public final int y;
        public final String id; // 정점좌표
        public final Set<String> connectedVertices;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = setId(x, y);
            this.connectedVertices = new HashSet<>();
        }

        public static String setId(int x, int y) {
            return String.format("(%d, %d)", x, y);
        }
    }

    // 순회좌표
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    // 새로운 방이 생성되는 조건 : 기존에 방문했던 정점을 새로운 간선을 통해 방문했을때
    public int solution(int[] arrows) {
        int answer = 0;
        Map<String, Vertex> vertices = new HashMap<>();

        // 원점에서 출발
        Vertex v = new Vertex(0, 0);
        vertices.put(v.id, v);

        for (int d : arrows) {
            for (int i = 0; i < 2; i++) { // 간선은 하나인데 중간에 지나가는 점이 있을수 있음
                int x = v.x + dx[d];
                int y = v.y + dy[d];
                String id = Vertex.setId(x, y);

                // 해당 좌표에 방문한적 없으면 추가해줘야 함
                if (!vertices.containsKey(id)) {
                    vertices.put(id, new Vertex(x, y));
                } else if (!v.connectedVertices.contains(id)) { // 방문한 적 있으면 간선 존재 유무를 확인해야 함
                    answer++;
                }

                // 간선을 이어주고 새로운 좌표로 이동
                Vertex u = vertices.get(id);
                v.connectedVertices.add(u.id);
                u.connectedVertices.add(v.id);
                v = vertices.get(id);
            }
        }

        return answer;
    }
}
