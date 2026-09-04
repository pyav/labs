/**
 * https://leetcode.com/problems/coin-change-ii/description/?q=Coin+Change
 *
 * Output:
 * ------
 * 4
 * 0
 * 1
 */

import java.util.Arrays;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int m = coins.length;
        int[][] arr = new int[1+m][1+amount];
        for (int i = 0; i <= m; i++) {
            arr[i][0] = 1;
        }
        for (int j = 1; j <= amount; j++) {
            arr[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                arr[i][j] = arr[i-1][j];
                if(j >= coins[i-1]) {
                    arr[i][j] += arr[i][j-coins[i-1]];
                }
            }
        }
        return arr[m][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(new CoinChangeII().change(5, coins));
        int[] coins2 = {2};
        System.out.println(new CoinChangeII().change(3, coins2));
        int[] coins3 = {10};
        System.out.println(new CoinChangeII().change(10, coins3));
    }
}

