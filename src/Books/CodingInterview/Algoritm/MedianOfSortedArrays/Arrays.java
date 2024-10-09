package src.Books.CodingInterview.Algoritm.MedianOfSortedArrays;


// 서로 다른 두 배열의 중앙값 구하기
// 두 배열의 length는 다를 수 있음에 유의
public class Arrays {
    // 웅앙값은 입력된 배열 데이터를 크기가 동일한 2개의 영억으로 나누는 것 = 중간 인덱스에 있음
    // q = [0, qPointer], [qPointer + 1, q.length], p도 동일
    // 정리하면, qPointer + pPointer = (q.length - qPointer) + (p.length - pPointer)

    // 길이가 같지 않을수도 있잖아?
    // qPointer = ((q.length - 1) + 0) / 2
    // pPointer = (q.length + p.length + 1) / 2 - qPointer

    // 배열은 무족건 정렬 = 왼쪽보다 오른쪽이 더 큼
    // p.length + q.length 가 짝수면 = 왼쪽 부분의 최대값과 오른쪽 부분의 최소값 평균
    // p.length + q.length 가 홀수면 = 왼쪽 부분의 최대값, max(q[qPointer - 1], p[pPointer - 1])

    public static float median(int[] q, int[] p) {
        int lenQ = q.length;
        int lenP = p.length;

        if (lenQ > lenP) {
            swap(q, p);
        }

        int qPointerMin = 0;
        int qPointerMax = q.length;
        int midLength = (q.length + p.length + 1) / 2;

        int qPointer, pPointer;

        while(qPointerMin <= qPointerMax) {
            qPointer = (qPointerMin + qPointerMax) / 2;
            pPointer = midLength - qPointer;

            // 이진검색
            if (qPointer < q.length && p[pPointer - 1] > q[qPointer]) { // p가 더 크면 q 증가
                qPointerMin = qPointer + 1;
            } else if (qPointer > 0 && q[qPointer - 1] > p[pPointer]) { // q가 더 크면 p 감소
                qPointerMax = qPointer - 1;
            } else {
                int maxLeft = 0;

                if (qPointer == 0) {
                    maxLeft = p[pPointer - 1];
                } else if (pPointer == 0) {
                    maxLeft = q[qPointer - 1];
                } else {
                    maxLeft = Integer.max(q[qPointer - 1], p[pPointer - 1]);
                }

                // 배열 q와 p의 길이의 합이 홀수이면, 왼쪽 영역의 최댓값을 반환
                if ((q.length + p.length) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;

                if (qPointer == q.length) {
                    minRight = p[pPointer];
                } else if (pPointer == p.length) {
                    minRight = q[qPointer];
                } else {
                    minRight = Integer.min(q[qPointer], p[pPointer]);
                }

                return (maxLeft + minRight) / 2.0f;
            }
        }

        return -1;
    }

    private static void swap(int[] q, int[] p) {
        int[] temp = q;
        q = p;
        p = temp;
    }

    /*
    스택이나 다른 곳에 넣어서 한번에 계산하는 방법도 생각해봤는데.... 참고삼아 AI한테 물어봤더니

    두 배열을 하나의 스택이나 배열로 합치고 중앙값을 찾는 방식은 다음과 같은 특징을 가질 것입니다:
        시간 복잡도: O(n+m) (병합 과정)
        공간 복잡도: O(n+m) (새로운 배열 생성)
        두 배열을 실제로 병합함
        중앙값 위치를 직접 계산할 수 있음

    구현 자체는 더 간결해질테지만 엄청 간단한 배열이 아닌 이상 지금 코드가 더 효율 좋다는 의견이...ㅇㅂㅇ...
     */
}
