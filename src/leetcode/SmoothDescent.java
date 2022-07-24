/**
 * https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
 *
 * Output:
 * ------
 * 7
 * 4
 * 1
 * 16
 */

package leetcode;

public class SmoothDescent {

    public long getDescentPeriods(int[] prices) {
        long count = 0;
		long len = 0;
        int effective = prices.length;
        int n = effective;

		for (int i = 0; i < n-1; i++) {
			if (prices[i]-prices[i+1] == 1) {
				len++;
			} else {
                len++;
                effective -= len;
				count += (len * (len + 1) / 2);
				if (len > 0) {
					len = 0;
				}
			}
		}
        if (len > 0) {
            count += (len * (len + 1) / 2);
        }
        count += effective;

		return count;
    }

    public static void main(String[] args) {
        int[] prices = {3,2,1,4};
        System.out.println(new SmoothDescent().getDescentPeriods(prices));
        int[] prices2 = {8,6,7,7};
        System.out.println(new SmoothDescent().getDescentPeriods(prices2));
        int[] prices3 = {1};
        System.out.println(new SmoothDescent().getDescentPeriods(prices3));
        int[] prices4 = {3,2,1,4,3,2,1};
        System.out.println(new SmoothDescent().getDescentPeriods(prices4));
    }

}

