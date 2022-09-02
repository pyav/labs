/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Output:
 * ------
 * 6
 * 9
 */

public class TrappingRainWater {

    public int trap(int[] height) {
        int volume = 0;
        int len = height.length;
        int[] leftHigh = new int[len];
        int[] rightHigh = new int[len];
        leftHigh[0] = height[0];
        for (int i = 1; i < len; i++) {
            if (height[i] > leftHigh[i-1]) {
                leftHigh[i] = height[i];
            } else {
                leftHigh[i] = leftHigh[i-1];
            }
        }
        rightHigh[len-1] = height[len-1];
        for (int i = len-2; i>= 0; i--) {
            if (height[i] > rightHigh[i+1]) {
                rightHigh[i] = height[i];
            } else {
                rightHigh[i] = rightHigh[i+1];
            }
        }
        for (int i = 0; i < len; i++) {
            volume += Math.min(leftHigh[i], rightHigh[i]) - height[i];
        }
        
        return volume;
    }

    public static void main(String[] args) {
        int[] ht = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(ht));
        int[] ht2 = {4,2,0,3,2,5};
        System.out.println(new TrappingRainWater().trap(ht2));
    }

}

