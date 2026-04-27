/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 
 * Output:
 * ------
 * 7
 * 4
 * 0
 * 8
 */

import java.util.Arrays;

public class BuyAndSellStockII {

	public int maxProfit(int[] prices) {
		int profit = 0;
		
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i+1] > prices[i]) {
				profit += (prices[i+1] - prices[i]);
			}
		}
		return profit;
    }

	public static void main(String[] args) {
		System.out.println(new BuyAndSellStockII().maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(new BuyAndSellStockII().maxProfit(new int[] {1,2,3,4,5}));		
		System.out.println(new BuyAndSellStockII().maxProfit(new int[] {7,6,4,3,1}));
		System.out.println(new BuyAndSellStockII().maxProfit(new int[] {3,3,5,0,0,3,1,4}));
	}

}
