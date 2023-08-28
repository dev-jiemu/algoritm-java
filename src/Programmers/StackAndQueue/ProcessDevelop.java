package src.Programmers.StackAndQueue;


import java.util.*;

class Process {
    public Integer index;
    public Integer progress;
    
    public Process(int index, int progress) {
        this.index = index;
        this.progress = progress;
    }
}
public class ProcessDevelop {

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            Process process = new Process(i, progresses[i]);
            queue.add(process);
        }

        ArrayList<Integer> publishCount = new ArrayList<>();

        while (!queue.isEmpty()) {
            for (Process process : queue) {
                process.progress += speeds[process.index]; // progress와 speed 배열 인덱스에 맞는 값 더함
            }

            // while문이 발생했을 때, 이전 개발건이 배포가 되었다면 poll이 발생하므로 자연스레 뒷 개발건도 개발이 완료되었거나 미완료된 상태를 체크 할 수 있음. (FIFO 구조)
            // 이것때문에 많이 햇갈렸는데 생각보다 단순했네;;;
            int count = 0;
            while (!queue.isEmpty() && queue.peek().progress >= 100) { // progress가 100이 넘었을때
                queue.poll();
                count++;
            }

            if (count > 0) {
                publishCount.add(count);
            }
        }

        int[] answer = new int[publishCount.size()];
        for (int i = 0; i < publishCount.size(); i++) {
            answer[i] = publishCount.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};

        int[] answer = solution(progresses, speeds);

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
     }
}
