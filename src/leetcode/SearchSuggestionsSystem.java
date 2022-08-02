/**
 * https://leetcode.com/problems/search-suggestions-system/
 *
 * Output:
 * ------
 * mobile moneypot monitor 
 * mobile moneypot monitor 
 * mouse mousepad 
 * mouse mousepad 
 * mouse mousepad 
 * havana 
 * havana 
 * havana 
 * havana 
 * havana 
 * havana 
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;

public class SearchSuggestionsSystem {

	private static int childrenCount = 26;

	static class Node {
		Node[] child = new Node[childrenCount];
		boolean isEndOfWord;

		Node() {
			for (int i = 0; i < child.length; i++) {
				child[i] = null;
			}
			isEndOfWord = false;
		}
	}

	private static Node root = null;

	public void insert(String word) {
		if (null == root) {
			root = new Node();
		}
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (null == node.child[index]) {
				node.child[index] = new Node();
			}
			node = node.child[index];
		}
		node.isEndOfWord = true;
	}

	private int count;

	private void func(Node node, List<String> listOfWords, List<Character> list, int idx) {
		if (null == node) {
			return;
		}
		if (node.isEndOfWord && count < 3) {
			listOfWords.add(list.stream().map(String::valueOf).collect(Collectors.joining()));
			count++;
		}
		for (int i = 0; i < childrenCount; i++) {
			if (null != node.child[i]) {
				list = list.subList(0, idx);
				list.add(idx, (char) ('a' + i));
				func(node.child[i], listOfWords, list, idx + 1);
			}
		}
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		root = new Node();
		for (String product : products) {
			insert(product);
		}
		List<List<String>> finalResult = new ArrayList<List<String>>();
		for (int i = 0; i < searchWord.length(); i++) {
			Node node = root;
			int j = 0;
			List<Character> list = new ArrayList<Character>();
			boolean isNullChild = false;
			while (j <= i) {
				list.add(j, searchWord.charAt(j));
				int index = searchWord.charAt(j) - 'a';
				if (node.child[index] == null) {
					isNullChild = true;
					break;
				}
				node = node.child[index];
				j++;
			}
			if (!isNullChild) {
				List<String> listOfWords = new ArrayList<String>();
				count = 0;
				func(node, listOfWords, list, j);
				finalResult.add(listOfWords);
			} else {
				finalResult.add(new ArrayList<String>());
			}
		}
		return finalResult;
	}

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		List<List<String>> result = new SearchSuggestionsSystem().suggestedProducts(products, searchWord);
		Iterator<List<String>> entry = result.iterator();
		while (entry.hasNext()) {
			List<String> list = entry.next();
			Iterator<String> value = list.iterator();
			while (value.hasNext()) {
				System.out.printf("%s ", value.next());
			}
			System.out.println();
		}
		String[] products2 = { "havana" };
		String searchWord2 = "havana";
		List<List<String>> result2 = new SearchSuggestionsSystem().suggestedProducts(products2, searchWord2);
		Iterator<List<String>> entry2 = result2.iterator();
		while (entry2.hasNext()) {
			List<String> list = entry2.next();
			Iterator<String> value = list.iterator();
			while (value.hasNext()) {
				System.out.printf("%s ", value.next());
			}
			System.out.println();
		}
	}

}
