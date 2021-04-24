/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * 
 * Output:
 * ------
 * 15
 * 6
 * 0
 */

package leetcode;

public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		int len = cost.length;
		int[] calculatedCost = new int[len];

		calculatedCost[0] = cost[0];
		calculatedCost[1] = Math.min(calculatedCost[0] + cost[1], cost[1]);

		for (int i = 2; i < len; i++) {
			calculatedCost[i] = Math.min(calculatedCost[i - 2], calculatedCost[i - 1]) + cost[i];
		}

		return Math.min(calculatedCost[len - 2], calculatedCost[len - 1]);
	}

	public static void main(String[] args) {
		int[] cost1 = { 10, 15, 20 };
		System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost1));
		int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost2));
		int[] cost3 = { 0, 100 };
		System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost3));
	}

}
