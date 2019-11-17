/**
 * Link for the problem statement:
 * ------------------------------
 * https://codeforces.com/contest/1253/problem/A
 */

import java.util.Scanner;

public class SinglePush {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int z = 0; z < t; z++) {
			
			int n = in.nextInt();
			int a[] = new int[n];
			
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}

			boolean printNo = false;
			boolean alreadyEqual = false;
			int k = 0;
			int b[] = new int[n];
			
			for (int i = 0; i < n; i++) {
				b[i] = in.nextInt();
			}
			
			for (int i = 0; i < n; i++) {
				if (b[i] == a[i]) {
					alreadyEqual = true;
					continue;
				} else if (b[i] < a[i]) {
					printNo = true;
					break;
				} else {
					if (alreadyEqual && (k > 0) && !(b[i-1] > a[i-1])) {
						printNo = true;
						break;
					}
					if (k != 0 && !((b[i] - a[i]) == k)) {
						printNo = true;
						break;
					}
					k = b[i] - a[i];
				}
			}
			
			if (printNo) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		
		in.close();
	}

}
