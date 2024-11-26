/**
 *
 */

public class JumpGameRecursiveMemoize {

    private int minJumpsRecurse(int i, int[] arr, int[] memo) {
        if (i >= arr.length - 1) {
            return 0;
        }
        if (-1 != memo[i]) {
            return memo[i];
        }
        int minJumps = Integer.MAX_VALUE;
        for (int j = i+1; j <= arr[i] + i; j++) {
            int val = minJumpsRecurse(j, arr, memo);
            if (val != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1+val);
            }
        }
        return memo[i] = minJumps;
    }

    private int minJumps(int[] arr) {

        int[] memo = new int[arr.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        int minJump = minJumpsRecurse(0, arr, memo);

        if (Integer.MAX_VALUE == minJump) {
            return -1;
        }

        return minJump;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(new JumpGameRecursiveMemoize().minJumps(arr));
    }
}

