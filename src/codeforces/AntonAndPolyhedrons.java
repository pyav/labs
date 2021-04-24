/**
 * https://codeforces.com/problemset/problem/785/A
 */

package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AntonAndPolyhedrons {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Tetrahedron", 4);
		map.put("Cube", 6);
		map.put("Octahedron", 8);
		map.put("Dodecahedron", 12);
		map.put("Icosahedron", 20);

		int sum = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			String shape = in.next();
			sum += map.get(shape).intValue();
		}

		System.out.println(sum);
		in.close();
	}

}
