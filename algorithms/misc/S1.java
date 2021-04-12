/**
 * Output:
 * ------
 * 2
 * 4
 * -1
 */

package tests;

import java.util.*;

public class S1 {

	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < queries.size(); i++) {
			boolean found = false;
			for (int j = 1; j < stockData.size(); j++) {
				if (queries.get(i) - j > 0) {
					if (stockData.get(queries.get(i) - j - 1) < stockData.get(queries.get(i) - 1)) {
						answer.add(queries.get(i) - j);
						found = true;
						break;
					}
				}
				if (queries.get(i) + j <= stockData.size()) {
					if (stockData.get(queries.get(i) + j - 1) < stockData.get(queries.get(i) - 1)) {
						answer.add(queries.get(i) + j);
						found = true;
						break;
					}
				}
			}
			if (!found) {
				answer.add(-1);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		List<Integer> data = new ArrayList<Integer>();
		data.add(5);
		data.add(6);
		data.add(8);
		data.add(4);
		data.add(9);
		data.add(10);
		data.add(8);
		data.add(3);
		data.add(6);
		data.add(4);
		List<Integer> query = new ArrayList<Integer>();
		query.add(3);
		query.add(1);
		query.add(8);
		List<Integer> answer = S1.predictAnswer(data, query);
		for (int ans : answer) {
			System.out.println(ans);
		}
	}

}
