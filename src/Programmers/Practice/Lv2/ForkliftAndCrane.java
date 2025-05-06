package src.Programmers.Practice.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class ForkliftAndCrane {

    // 방향
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // BFS 사용해야 할듯?
    // 상태 체크도 필요할듯 : 이전에 꺼낸 컨테이너 종류 다시 안꺼냄
    public int solution(String[] storage, String[] requests) {
        int answer = 0;

        // 문자열 하나 : 접근 가능한거 꺼냄(최소 한면이 외부랑 연결되어 있는 경우만)
        // 두개가 연속으로 들어옴 : 전부 다꺼냄

        int n = storage.length;
        int m = storage[0].length();

        char[][] containers = new char[n][m];

        // 컨테이너 정보 저장
        for(int i = 0; i < n; i++) {
            String line = storage[i];
            for(int j = 0; j < m; j++) {
                containers[i][j] = line.charAt(j);
            }
        }

        for(String request : requests) {
            char type = request.charAt(0); // 컨테이너 이름

            if (request.length() == 1) {
                removeAccessibleContainers(containers, type);
            } else {
                removeAllContainers(containers, type);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] != '.') {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void removeAccessibleContainers(char[][] containers, char type) {
        int n = containers.length;
        int m = containers[0].length;
        boolean[][] accessible = new boolean[n][m]; // 접근 가능한 위치 표시

        // 먼저 외부와 연결된 빈 공간을 찾기 위한 BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // 가장자리에 있는 빈 공간을 큐에 추가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n-1 || j == 0 || j == m-1)) {
                    // 가장자리는 모두 접근 가능
                    accessible[i][j] = true;

                    // 빈 공간인 경우 큐에 추가하여 내부로 탐색
                    if (containers[i][j] == '.') {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (containers[nx][ny] == '.') { // ** 빈 공간도 접근 가능하게 표시하고 큐에 추가
                        accessible[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    } else {
                        accessible[nx][ny] = true; // 가장자리는 접근 가능유무 표시
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (accessible[i][j] && containers[i][j] == type) {
                    containers[i][j] = '.';
                }
            }
        }
    }

    private void removeAllContainers(char[][] containers, char type) {
        int n = containers.length;
        int m = containers[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (containers[i][j] == type) {
                    containers[i][j] = '.';
                }
            }
        }
    }
}
