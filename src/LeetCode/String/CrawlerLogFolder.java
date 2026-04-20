package src.LeetCode.String;

// 1598. Crawler Log Folder
// https://leetcode.com/problems/crawler-log-folder/
public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int result = 0;

        for(String log : logs) {
            if (log.equals("../")) {
                result = Math.max(0, result - 1); // root 보다 위로는 못감
            } else if (!log.equals("./")) {
                result++; // 하위 폴더로 이동
            }
        }

        return result;
    }
}
