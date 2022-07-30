/**
 * https://leetcode.com/problems/coin-change/
 *
 * Output:
 * ------
 * 3
 * -1
 * 0
 * 2
 * 20
 */

package leetcode;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] arr = new int[1+m][1+amount];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {
            arr[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j >= coins[i-1]) {
                    int distance = j-coins[i-1];
                    int t = Integer.MAX_VALUE;
                    if (arr[i][distance] != Integer.MAX_VALUE) {
                        t = 1+arr[i][distance];
                    }
                    arr[i][j] = Math.min(arr[i-1][j], t);
                } else {
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        return (arr[m][amount] == Integer.MAX_VALUE)? -1: arr[m][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(new CoinChange().coinChange(coins, 11));
        int[] coins2 = {2};
        System.out.println(new CoinChange().coinChange(coins2, 3));
        int[] coins3 = {1};
        System.out.println(new CoinChange().coinChange(coins3, 0));
        int[] coins4 = {1,2,3};
        System.out.println(new CoinChange().coinChange(coins4, 4));
        int[] coins5 = {186,419,83,408};
        System.out.println(new CoinChange().coinChange(coins5, 6249));
    }

}

