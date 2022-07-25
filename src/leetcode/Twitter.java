/**
 * https://leetcode.com/problems/design-twitter/
 * 
 * Output:
 * ------
 * 5
 */

package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

	Map<Integer, Set<Integer>> followerMap;
	int tweetCount;
	Map<Integer, Integer> tweetIdCountMap;
	Map<Integer, List<Integer>> userIdTweetIdMap;

	public Twitter() {
		followerMap = new HashMap<Integer, Set<Integer>>();
		tweetCount = 0;
		tweetIdCountMap = new HashMap<Integer, Integer>();
		userIdTweetIdMap = new HashMap<Integer, List<Integer>>();
	}

	public void postTweet(int userId, int tweetId) {
		tweetCount++;
		tweetIdCountMap.put(tweetId, tweetCount);
		List<Integer> tweets = userIdTweetIdMap.get(userId);
		if (tweets == null) {
			tweets = new ArrayList<Integer>();
		}
		tweets.add(tweetId);
		userIdTweetIdMap.put(userId, tweets);
	}

	public List<Integer> getNewsFeed(int userId) {
		Set<Integer> allUsers = new HashSet<Integer>();
		allUsers.add(userId);
		Set<Integer> followees = followerMap.get(userId);
		if (followees != null) {
			allUsers.addAll(followees);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(tweetIdCountMap.get(o2), tweetIdCountMap.get(o1));
			}
		});
		for (Integer user : allUsers) {
			List<Integer> tweets = userIdTweetIdMap.get(user);
			if (tweets != null) {
				for (Integer tweet : tweets) {
					pq.add(tweet);
				}
			}
		}
		List<Integer> recentTweets = new ArrayList<Integer>();
		for (int i = 0; i < 10 && pq.size() > 0; i++) {
			recentTweets.add(pq.remove());
		}
		return recentTweets;
	}

	public void follow(int followerId, int followeeId) {
		Set<Integer> followees = followerMap.get(followerId);
		if (followees == null) {
			followees = new HashSet<Integer>();
		}
		followees.add(followeeId);
		followerMap.put(followerId, followees);
	}

	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followees = followerMap.get(followerId);
		if (followees != null) {
			followees.remove(followeeId);
			followerMap.put(followerId, followees);
		}
	}

	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		twitter.unfollow(1, 2);
		List<Integer> param = twitter.getNewsFeed(1);
		for (Integer i : param) {
			System.out.println(i);
		}
	}

}
