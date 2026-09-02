package src.LeetCode.LinkedList;

import src.LeetCode.common.ListNode;

// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1, -1};

        ListNode prev = head;
        ListNode cur = head.next;

        int prevIndex = -1;
        int firstIndex = -1; // 이거 먼저 찾으면 됨

        int curIndex = 1;

        while(cur != null && cur.next != null){
            int prevValue = prev.val;
            int nextValue = cur.next.val;
            int curValue = cur.val;

            // value 값 비교
            boolean isMax = curValue > prevValue && curValue > nextValue;
            boolean isMin = curValue < prevValue && curValue < nextValue;

            if (isMax || isMin) {
                if (firstIndex == -1) {
                    firstIndex = curIndex; // 첫 critical point 인덱스 저장
                } else {
                    int distance = curIndex - prevIndex;
                    if (result[0] == -1 || distance < result[0]) {
                        result[0] = distance; // minDistance 갱신
                    }
                }
                prevIndex = curIndex; // 마지막으로 찾은 critical point 인덱스 갱신
            }

            // 맨 끝 노드 직전까지만 탐색할거라서 next.next 로 접근
            // 이렇게 했는데 노드가 2개면 nextValue 지정할때 exception 나서, 그냥 while 문을 바꿈 ㅇㅂㅇ
//            if (cur.next.next == null) {
//                cur = null; // while 문 종료
//            } else {
                curIndex++;
                prev = cur;
                cur = cur.next;
//            }
        }

        if (result[0] != -1) {
            result[1] = prevIndex - firstIndex; // maxDistance = 처음 critical point ~ 마지막 critical point
        }

        return result;
    }
}
