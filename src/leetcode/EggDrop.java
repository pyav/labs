/**
 * https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 *
 * Output:
 * ------
 * 2
 * 14
 */

public class EggDrop {

    public int twoEggDrop(int n) {
        int record[][] = new int [3][n+1];
        int i, j, x, result;

        for (i = 1; i <= 2; i++) {
            record[i][0] = 0;
            record[i][1] = 1;
        }
        for (i = 1; i <= n; i++) {
            record[1][i] = i;
        }
        for (j = 2; j <= n; j++) {
            record[2][j] = Integer.MAX_VALUE;
            for (x = 1; x <= j; x++) {
                result = 1 + Math.max(record[1][x - 1], record[2][j - x]);
                if (result < record[2][j]) {
                    record[2][j] = result;
                }
            }
        }

        return record[2][n];
    }

    public static void main(String[] args) {
        System.out.println(new EggDrop().twoEggDrop(2));
        System.out.println(new EggDrop().twoEggDrop(100));
    }

}

