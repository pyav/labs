/**
 *
 */

public class JumpGameRecursive {

    private int minJumpsRecurse(int i, int[] arr) {
        if (i >= arr.length - 1) {
            return 0;
        }
        int minJumps = Integer.MAX_VALUE;
        for (int j = i+1; j <= arr[i] + i; j++) {
            int val = minJumpsRecurse(j, arr);
            if (val != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1+val);
            }
        }
        return minJumps;
    }

    private int minJumps(int[] arr) {
        int minJump = minJumpsRecurse(0, arr);

        if (Integer.MAX_VALUE == minJump) {
            return -1;
        }

        return minJump;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(new JumpGameRecursive().minJumps(arr));
    }
}

