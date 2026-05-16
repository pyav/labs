/*
 * https://leetcode.com/problems/random-pick-with-weight/description/
 *
 * Output:
 * ------
 * 1
 * 1
 * 1
 * 0
 * 1
 */

import java.util.Random;

public class PickWeight {

    private int[] wt = null;
    private int max = -1;
    private Random rand = null;
    
    public PickWeight(int[] w) {
        this.wt = new int[w.length];
        wt[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            wt[i] = wt[i-1] + w[i];
        }
        max = this.wt[wt.length-1];
        rand = new Random();
    }

    public int pickIndex() {
        int randomNum = rand.nextInt(max) + 1;
        int left = 0;
        int right = wt.length-1;

        while(left < right) {
            int mid = left + (right-left)/2;
            if (wt[mid] < randomNum) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] wt = {1, 3};
        PickWeight obj = new PickWeight(wt);
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
    }
}

