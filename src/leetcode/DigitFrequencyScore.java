/**
 * https://leetcode.com/problems/digit-frequency-score/
 *
 * Output:
 * ------
 * 5
 * 2
 */

public class DigitFrequencyScore {
    public int digitFrequencyScore(int n) {
        String str = String.valueOf(n);
        int[] count = new int[10];

        for (Character t : str.toCharArray()) {
            count[t-'0']++;
        }

        int result = 0;
        for (int i = 0; i < count.length; i++) {
            result += i*count[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DigitFrequencyScore().digitFrequencyScore(122));
        System.out.println(new DigitFrequencyScore().digitFrequencyScore(101));
    }
}

