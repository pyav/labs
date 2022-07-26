/**
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * Output:
 * ------
 * i love 
 * the is sunny day 
 */

package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

public class TopKFrequentWords {

	Map<String, Integer> map = new HashMap<String, Integer>();

	public List<String> topKFrequent(String[] words, int k) {
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<>() {
			public int compare(String s1, String s2) {
				if (map.get(s1) == map.get(s2)) {
					return s1.compareTo(s2);
				}
				return Integer.compare(map.get(s2), (map.get(s1)));
			}
		});
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
		for (String key : map.keySet()) {
			pq.add(key);
		}
		List<String> result = new ArrayList<String>();
		while (k-- > 0) {
			result.add(pq.poll());
		}
		return result;
	}

	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		List<String> result = new TopKFrequentWords().topKFrequent(words, 2);
		for (String word : result) {
			System.out.printf("%s ", word);
		}
		System.out.println();
		String[] words2 = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		List<String> result2 = new TopKFrequentWords().topKFrequent(words2, 4);
		for (String word : result2) {
			System.out.printf("%s ", word);
		}
	}

}
