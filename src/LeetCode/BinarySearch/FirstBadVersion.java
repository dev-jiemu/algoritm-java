package src.LeetCode.BinarySearch;

// https://leetcode.com/problems/first-bad-version/?envType=problem-list-v2&envId=binary-search
public class FirstBadVersion {
    public int firstBadVersion(int n) { // VersionControl extends
        int left = 1;
        int right = n;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(isBadVersion(mid)) { // 크거나 같으면 true
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 빨간줄 방지용 ㅇㅂㅇ
    private boolean isBadVersion(int mid) {
        return true;
    }
}
