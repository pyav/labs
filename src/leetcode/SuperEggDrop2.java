/**
 * https://leetcode.com/problems/super-egg-drop/
 *
 * Output:
 * ------
 * 2
 * 3
 * 4
 * 14
 */

public class SuperEggDrop2 {

    public int superEggDrop(int k, int n) {
        int record[][] = new int [n+1][k+1];
        int i, j, x, result;

        for (i = 1; i <= n; i++) {
            record[i][0] = 0;
        }
        int m = 0;
        while (record[m][k] < n) {
            m++;
            for (x = 1; x <= k; x++) {
                record[m][x] = 1 + record[m-1][x-1] + record[m-1][x];
            }
        }

        return m;
    }

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop2().superEggDrop(1, 2));
        System.out.println(new SuperEggDrop2().superEggDrop(2, 6));
        System.out.println(new SuperEggDrop2().superEggDrop(3, 14));
        System.out.println(new SuperEggDrop2().superEggDrop(10, 10000));
    }

}

