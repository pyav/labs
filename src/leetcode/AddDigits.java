/**
 * https://leetcode.com/problems/add-digits/description/
 *
 * Output:
 * ------
 * 2
 * 0
 * 1
 */

public class AddDigits {
    private int addDigits(int num, int sum) {
        if (num < 10) {
            return num;
        }
        while(num > 0) {
            sum += num%10;
            num /= 10;
        }
        return addDigits(sum, 0);
    }

    public int addDigits(int num) {
        return addDigits(num, 0);
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
        System.out.println(new AddDigits().addDigits(0));
        System.out.println(new AddDigits().addDigits(2147483647));
    }
}

