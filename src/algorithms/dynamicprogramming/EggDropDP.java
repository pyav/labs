/**
 * Following program calculates the minimum trials in Egg Drop puzzle using
 * Dynamic programming techniques. 
 *
 * Output
 * ------
 * Minimum number of trials in worst case with 2 eggs and 10 floors is 4
 */

public class EggDropDP {

    static int max (int a, int b) {
        return (a > b? a: b);
    }

    static int calcMinTrials(int numEggs, int floors) {
        int record[][] = new int [numEggs + 1][floors + 1];
        int i, j, x, result;

        for (i = 1; i <= numEggs; i++) {
            record[i][0] = 0;
            record[i][1] = 1;
        }
        for (i = 1; i <= floors; i++) {
            record[1][i] = i;
        }

        for (i = 2; i <= numEggs; i++) {
            for (j = 2; j <= floors; 	j++) {
                record[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    result = 1 + max(record[i - 1][x - 1], record[i][j - x]);
                    if (result < record[i][j]) {
                        record[i][j] = result;
                    }
                }
            }
        }

        return record[numEggs][floors];
    }

    public static void main(String[] args) {
        int numEggs = 2;
        int floors = 10;
        System.out.printf("Minimum number of trials in worst case with " + 
                "%d eggs and %d floors is %d\n", numEggs, floors, 
                calcMinTrials(numEggs, floors));
    }

}
