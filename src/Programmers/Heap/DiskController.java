package src.Programmers.Heap;
import java.util.*;


// 이거 테스트케이스 1개만 놓고봐선 안풀려서 힌트 참고함
// https://school.programmers.co.kr/learn/courses/14743/lessons/118893
// 단순하게 소요시간 기준으로 우선순위를 돌려야한다고 생각했는데, 작업 요청하는 시간 기준(즉, 시작시점이요...)으로도 정렬이 필요한거였음.
class ProcessDisk implements Comparable<ProcessDisk>{
    private int start; // 작업 요청 시점
    private int time;  // 작업 소요 시간

    public ProcessDisk(int start, int time) {
        this.start = start;
        this.time = time;
    }

    public int getStart() {
        return this.start;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public int compareTo(ProcessDisk o) {
        return Integer.compare(this.time, o.time); // 작업 소요 시간 기준으로 오름차순 정렬
    }
}

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 작업 요청 시점을 기준으로 오름차순 정렬

        PriorityQueue<ProcessDisk> process = new PriorityQueue<>();

        int time = 0;
        int index = 0;
        while (index < jobs.length || !process.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= time) {
                process.add(new ProcessDisk(jobs[index][0], jobs[index][1]));
                index++;
            }

            if (!process.isEmpty()) {
                ProcessDisk current = process.poll();
                answer += time - current.getStart() + current.getTime();
                time += current.getTime();
            } else {
                time = jobs[index][0];
            }
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        DiskController controller = new DiskController();

        int result = controller.solution(jobs);

        System.out.println("result : " + result);
    }
}
