package src.Books.CodingInterview.LinkedListAndMap.LinkedListLoopDetection;

import src.Books.CodingInterview.LinkedListAndMap.Node;

public class LoopDetection {
    // 빠른 러너, 느린 러너
    // 1. 둘이 동시에 출발함
    // 2. 빠른 러너는 2칸, 느린 러너는 1칸씩 이동
    // 3. 둘이 만나면 느린 러너는 머리 노드로 이동
    // 4. 이후부턴 둘이 한칸씩만 이동하는데 만나면 머리노드임

    private Node head;
    private Node tail;

    public void findLoopStartNode() {
        Node slowRunner = head;
        Node fastRunner = head;

        while(fastRunner != null && slowRunner != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if (slowRunner == fastRunner) {
                break;
            }
        }

        if (fastRunner == null || fastRunner.next == null) {
            return;
        }

        slowRunner = head; // 머리 노드로 이동

        while(slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        System.out.println("시작점 : " + fastRunner);
    }
}
