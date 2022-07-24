/**
 * https://leetcode.com/contest/biweekly-contest-83/problems/best-poker-hand/
 * 
 * Output
 * ------
 * Pair
 */

package leetcode.biweekly83;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BestPokerHand {

	public String bestHand(int[] ranks, char[] suits) {
		Map<Character, Integer> mapSuits = new HashMap<Character, Integer>();
		Map<Integer, Integer> mapRanks = new HashMap<Integer, Integer>();
		for (int i = 0; i < 5; i++) {
			if (mapSuits.containsKey(suits[i])) {
				int val = mapSuits.get(suits[i]);
				mapSuits.put(suits[i], val + 1);
			} else {
				mapSuits.put(suits[i], 1);
			}
			if (mapRanks.containsKey(ranks[i])) {
				int val = mapRanks.get(ranks[i]);
				mapRanks.put(ranks[i], val + 1);
			} else {
				mapRanks.put(ranks[i], 1);
			}
		}
		if (mapSuits.size() == 1) {
			return "Flush";
		}
		for (Entry<Integer, Integer> entry : mapRanks.entrySet()) {
			int val = entry.getValue();
			if (val >= 3) {
				return "Three of a Kind";
			}
		}
		for (Entry<Integer, Integer> entry : mapRanks.entrySet()) {
			int val = entry.getValue();
			if (val >= 2) {
				return "Pair";
			}
		}
		return "High Card";
	}

	public static void main(String[] args) {
		int[] ranks = {10,10,2,12,9};
		char[] suits = {'a','b','c','a','d'};
		System.out.println(new BestPokerHand().bestHand(ranks, suits));
		
	}

}

