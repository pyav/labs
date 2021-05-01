/**
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * Output:
 * ------
 * 3
 */

package leetcode;

import java.util.Arrays;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        boolean[] isPointing = new boolean[N];
        Arrays.fill(isPointing, false);
        int[] countPointers = new int[N];
        Arrays.fill(countPointers, 0);
        for (int i = 0; i < trust.length; i++) {
            int first = trust[i][0]-1;
            int second = trust[i][1]-1;
            isPointing[first] = true;
            countPointers[second] += 1;
        }
        for (int i = 0; i < N; i++) {
            if (!isPointing[i] && countPointers[i] == N-1) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {{1, 3}, {2, 3}};
        System.out.println(new FindTheTownJudge().findJudge(3, trust));
    }

}

