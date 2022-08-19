/**
 * https://leetcode.com/problems/group-anagrams/
 * 
 * Output:
 * ------
 * tan nat 
 * tea ate eat 
 * bat 
 * 
 * a
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class GroupAnagrams {

	private class Node {
		String str;
		int idx;
		public Node(String str, int idx) {
			this.str = str;
			this.idx = idx;
		}
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(GroupAnagrams.Node o1, GroupAnagrams.Node o2) {
				return o2.str.compareTo(o1.str);
			}
		});
		
        for (int i = 0; i < strs.length; i++) {
        	char[] charArr = strs[i].toCharArray();
        	Arrays.sort(charArr);
        	pq.add(new GroupAnagrams.Node(String.valueOf(charArr), i));
        }
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> first = new ArrayList<String>();
        Node tmp = pq.peek();
        
        while(!pq.isEmpty()) {
        	if (first.size() == 0) {
        		first.add(strs[tmp.idx]);
        		pq.poll();
        	} else {
        		Node node = pq.poll();
        		if (tmp.str.equals(node.str)) {
        			first.add(strs[node.idx]);
        		} else {
        			result.add(new ArrayList<String> (first));
        			first.clear();
        			first.add(strs[node.idx]);
        			tmp = node;
        		}
        	}
        }
        if (first.size() > 0) {
        	result.add(new ArrayList<String> (first));
        }
        return result;
    }
	
	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
		Iterator<List<String>> itr = result.iterator();
		while(itr.hasNext()) {
			List<String> list = itr.next();
			for (String val : list) {
				System.out.printf("%s ", val);
			}
			System.out.println();
		}
		// 2nd case
		String[] strs2 = {""};
		List<List<String>> result2 = new GroupAnagrams().groupAnagrams(strs2);
		Iterator<List<String>> itr2 = result2.iterator();
		while(itr2.hasNext()) {
			List<String> list = itr2.next();
			for (String val : list) {
				System.out.printf("%s", val);
			}
			System.out.println();
		}
		// 3rd case
		String[] strs3 = {"a"};
		List<List<String>> result3 = new GroupAnagrams().groupAnagrams(strs3);
		Iterator<List<String>> itr3 = result3.iterator();
		while(itr3.hasNext()) {
			List<String> list = itr3.next();
			for (String val : list) {
				System.out.printf("%s", val);
			}
		}
	}

}
