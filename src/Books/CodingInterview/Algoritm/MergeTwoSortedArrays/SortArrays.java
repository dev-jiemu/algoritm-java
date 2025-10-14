package src.Books.CodingInterview.Algoritm.MergeTwoSortedArrays;


// 1. 정렬된 배열 2개 병합하기
// 정렬하는 과정에서 배열을 새로 만드는게 아님 (p는 q를 다 넣고도 남을 정도의 길이가 있다고 가정함)
public class SortArrays {
    public void merge(int[] p, int[] q) {
        int pLast = p.length - q.length;
        int qLast = q.length;

        int pIdx = pLast - 1;
        int qIdx = qLast - 1;
        int mInx = pLast + qLast - 1;

        // 끝점에서 시작함
        // 둘이 비교해서 하나 선택해서 넣고 인덱스 줄임
        while(qIdx >= 0) {
            if (pIdx >= 0 && p[pIdx] > q[qIdx]) {
                p[mInx] = p[pIdx];
                pIdx--;
            } else {
                p[mInx] = q[qIdx];
                qIdx--;
            }

            mInx--;
        }
    }
}
