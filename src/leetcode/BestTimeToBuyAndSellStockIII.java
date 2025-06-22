/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * Output:
 * ------
 * 7
 * 4
 * 0
 * 6
 */

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] profit = new int[n];
        int maxSoFar = prices[n-1];

        for (int i = n-2; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, prices[i]);
            profit[i] = Math.max(maxSoFar - prices[i], profit[i+1]);
        }

        int minSoFar = prices[0];
        int result = 0;
        for (int i = 1; i < n; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            result = Math.max(prices[i] - minSoFar + profit[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
        int[] prices2 = {1,2,3,4,5};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices2));
        int[] prices3 = {7,6,4,3,1};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices3));
        int[] prices4 = {3,3,5,0,0,3,1,4};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices4));
    }
}

