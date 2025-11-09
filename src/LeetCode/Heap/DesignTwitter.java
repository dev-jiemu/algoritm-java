package src.LeetCode.Heap;

import java.util.*;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
*/
public class DesignTwitter {
    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> followMap; // 중복 팔로우 방지

    // 트윗의 시간 순서를 구분하기 위한 타임스탬프
    private int timestamp = 0;

    public DesignTwitter() {
        this.userTweets = new HashMap<>();
        this.followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }

        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // 내림차순 정렬
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // 1. 내 트윗 추가
        if (userTweets.containsKey(userId)) {
            maxHeap.addAll(userTweets.get(userId));
        }

        // 2. follow 하는 사람 있으면 그 트윗 추가
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    maxHeap.addAll(userTweets.get(followeeId));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10 && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
