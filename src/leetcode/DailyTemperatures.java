/**
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * Output:
 * ------
 * 1 1 4 2 1 1 0 0 
 * 1 1 1 0 
 * 3 1 1 2 1 1 0 1 1 0
 */

import java.util.Arrays;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] v = new int[temperatures.length];
        int[] c = new int[temperatures.length];
        v[v.length-1] = 0;
        c[c.length-1] = 0;
        int maxIdxSoFar = temperatures.length - 1;
        for (int i = temperatures.length-2; i >= 0; i--) {
            if (temperatures[i+1] > temperatures[i]) {
                v[i] = temperatures[i+1];
                c[i] = 1;
            } else if (v[i+1] > temperatures[i]) {
                v[i] = v[i+1];
                c[i] = c[i+1] + 1;
            } else if (temperatures[maxIdxSoFar] > temperatures[i]) {
                for (int j = i+1; j <= maxIdxSoFar; j++) {
                    if (temperatures[j] > temperatures[i]) {
                        v[i] = temperatures[j];
                        c[i] = j - i;
                        break;
                    }
                }
            } else {
                v[i] = 0;
                c[i] = 0;
            }
            if (temperatures[i] > temperatures[maxIdxSoFar]) {
                maxIdxSoFar = i;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = new DailyTemperatures().dailyTemperatures(temperatures);
        Arrays.stream(result).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] temperatures2 = {3,4,5,6};
        int[] result2 = new DailyTemperatures().dailyTemperatures(temperatures2);
        Arrays.stream(result2).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
        int[] temperatures3 = {55,38,53,81,61,93,97,32,43,78};
        int[] result3 = new DailyTemperatures().dailyTemperatures(temperatures3);
        Arrays.stream(result3).forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }
}

