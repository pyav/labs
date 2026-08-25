/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/
 *
 * Output:
 * ------
 * 2
 * 3
 * 3
 * 1
 */

import java.util.HashMap;
import java.util.Map;

public class MinOperations {
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int minOperations(int n) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int lowerPower = Integer.highestOneBit(n);

        if (lowerPower == n) {
            return 1;
        }

        int upperPower = lowerPower << 1;

        int result = 1 + Math.min(
                minOperations(n - lowerPower),
                minOperations(upperPower - n)
                );

        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinOperations().minOperations(7));
        System.out.println(new MinOperations().minOperations(39));
        System.out.println(new MinOperations().minOperations(54));
        System.out.println(new MinOperations().minOperations(1));
    }
}
