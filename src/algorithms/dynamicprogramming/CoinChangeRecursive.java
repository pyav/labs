/**
 * This program finds number of ways to get the change of N paise given the
 * array of values of coins. The coins are of infinite number.
 *
 * Output:
 * ------
 * 4
 */

public class CoinChangeRecursive {

    public int count(int[] S, int m, int n) {
        if (m <= 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return count(S, m, n-S[m-1]) + count(S, m-1, n);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(new CoinChangeRecursive().count(coins, coins.length, 4));
    }

}

