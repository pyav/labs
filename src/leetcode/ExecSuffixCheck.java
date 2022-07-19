/**
 * https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 *
 * Output:
 * ------
 * 1 5 4 3 1 0 
 */

package leetcode;

public class ExecSuffixCheck {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int len = s.length();
        int[] answer = new int[len];
        for (int i = 1; i <= len; i++) {
            int x = startPos[0];
            int y = startPos[1];
            int count = 0;
            for (int j = i-1; j < len; j++) {
                if (s.charAt(j) == 'L') {
                    if (y>0) {
                        y--;
                        count++;
                        continue;
                    }
                    break;
                } else if (s.charAt(j) == 'U') {
                    if (x>0) {
                        x--;
                        count++;
                        continue;
                    }
                    break;
                } else if (s.charAt(j) == 'R') {
                    if (y<n-1) {
                        y++;
                        count++;
                        continue;
                    }
                    break;
                } else if (s.charAt(j) == 'D') {
                    if (x<n-1) {
                        x++;
                        count++;
                        continue;
                    }
                    break;
                }
            }
            answer[i-1] = count;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        int[] result = new ExecSuffixCheck().executeInstructions(3, new int[] {0,1}, "RRDDLU");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d ", result[i]);
        }
    }

}

