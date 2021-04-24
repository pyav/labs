/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Output:
 * ------
 * 49
 */

package leetcode;

public class ContainerWithMostWater {
    private int getMin(int a, int b) {
        return (a<b)? a: b;
    }

    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            int count = 1;

            for (int j = i+1; j < height.length; j++) {
                int min = getMin(height[i], height[j]);
                if (max < count*min) {
                    max = count*min;
                }
                count++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = {1,1};
        //int[] height = {4,3,2,1,4};
        //int[] height = {1,2,1};
        //int[] height = {0,0};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}

