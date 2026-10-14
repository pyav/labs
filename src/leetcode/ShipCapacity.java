/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * Output:
 * ------
 * 15
 * 6
 * 3
 */

public class ShipCapacity {
    public int shipWithinDays(int[] weights, int days) {
        int maxWt = 0;
        int totalWt = 0;

        for (int wt : weights) {
            totalWt += wt;
            maxWt = Math.max(wt, maxWt);
        }

        while(maxWt < totalWt) {
            int midWt = maxWt + (totalWt - maxWt)/2;
            int sum = 0;
            int day = 1;

            for(int i = 0; i < weights.length; i++) {
                if (sum + weights[i] > midWt) {
                    day++;
                    sum = 0;
                }
                sum += weights[i];
            }
            if (day <= days) {
                totalWt = midWt;
            } else {
                maxWt = midWt + 1;
            }
        }

        return maxWt;
    }

    public static void main(String[] args) {
        System.out.println(new ShipCapacity().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(new ShipCapacity().shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(new ShipCapacity().shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}

