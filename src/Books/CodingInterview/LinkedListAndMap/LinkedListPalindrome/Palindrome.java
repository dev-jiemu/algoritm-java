package src.Books.CodingInterview.LinkedListAndMap.LinkedListPalindrome;

import src.Books.CodingInterview.LinkedListAndMap.Node;

import java.util.Stack;

public class Palindrome {
    // 연결 리스트의 왼쪽 절반 = 오른쪽 절반의 반전 => 회문
    public Node head;
    public Node tail;

    public boolean isPalindrome() {
        Node fastRunner = head;
        Node slowRunner = head;
        Stack<Integer> firstHalf = new Stack<>();

        while(fastRunner != null && fastRunner.next != null) {
            firstHalf.push(slowRunner.data);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        // 요소가 홀수일때
        if (fastRunner != null) {
            slowRunner = slowRunner.next;
        }

        while(slowRunner != null) {
            int top = firstHalf.pop(); // 반전으로 비교해야하니까 pop으로 하나씩 뺌

            if (top != slowRunner.data) {
                return false;
            }

            slowRunner = slowRunner.next;
        }

        return true;
    }
}
