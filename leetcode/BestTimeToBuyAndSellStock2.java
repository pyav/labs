/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Output:
 * ------
 * 3
 */

package leetcode;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        min[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            min[i] = (prices[i]>min[i-1])? min[i-1]: prices[i];
        }

        int[] max = new int[prices.length];
        max[prices.length-1] = prices[prices.length-1];

        for (int i = prices.length-2; i>=0; i--) {
            max[i] = (prices[i]>max[i+1])? prices[i]: max[i+1];
        }
        
        int finalProfit = 0;
        for (int i=0; i<prices.length-1; i++) {
            if (max[i+1]-min[i]>finalProfit) {
                finalProfit = max[i+1]-min[i];
            }
        }
        return finalProfit;
    }
    
    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,4,2};
        //int[] prices = {7,6,4,3,1};
        //int[] prices = {};
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(prices));
    }
}
