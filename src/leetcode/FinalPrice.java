/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * Output:
 * ------
 * 4
 * 2
 * 4
 * 2
 * 3
 */

public class FinalPrice {

    private int getMinAfterI(int[] prices, int i) {
        int min = 0;
        for (int j = i+1; j < prices.length; j++) {
            if (prices[j] <= prices[i]) {
                min = prices[j];
                break;
            }
        }
        return min;
    }

    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] -= getMinAfterI(prices, i);
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        int[] result = new FinalPrice().finalPrices(prices);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}

