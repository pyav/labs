/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 *
 * Output:
 * ------
 * 2147483647
 */

public class GuessNumber {

    private int guess(int num) {
        if (num == 2147483647 || num == 5) {
            return 0;
        } else if (num < 5) {
            return 1;
        } else if (num > 10) {
            return -1;
        }
        return 0;
    }


    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int mid = start + (end - start)/2;
        int num = -1;

        while(start <= end) {
            mid = start + (end - start)/2;
            num = guess(mid);
            if (num == 0) {
                num = mid;
                break;
            } else if (num == 1) {
                start = mid + 1;
            } else if (num == -1) {
                end = mid - 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2147483647));
    }

}

