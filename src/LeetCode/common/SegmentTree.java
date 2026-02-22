package src.LeetCode.common;

public class SegmentTree {
    int[] tree;
    int n;

    SegmentTree(int n) {
        this.n = n;
        tree = new int[4 * n]; // 트리 크기는 보통 4*n으로 잡음 (max size)
    }

    // idx: 현재 노드, start~end: 현재 노드가 담당하는 구간
    void update(int idx, int start, int end, int target, int val) {
        if (start == end) {
            tree[idx] += val; // 리프 노드
            return;
        }
        int mid = (start + end) / 2;
        if (target <= mid) {
            update(idx*2, start, mid, target, val);     // 왼쪽 자식
        } else {
            update(idx*2+1, mid+1, end, target, val);   // 오른쪽 자식
        }

        tree[idx] = tree[idx*2] + tree[idx*2+1]; // 자식들 합으로 갱신
    }

    // left~right 구간의 합 쿼리
    int query(int idx, int start, int end, int left, int right) {
        if (right < start || end < left) return 0; // 범위 밖
        if (left <= start && end <= right) return tree[idx]; // 완전히 포함

        int mid = (start + end) / 2;
        return query(idx*2, start, mid, left, right) + query(idx*2+1, mid+1, end, left, right);
    }
}