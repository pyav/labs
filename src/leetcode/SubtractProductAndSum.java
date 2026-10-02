/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/
 *
 * Output:
 * ------
 * 15
 * 21
 * 0
 * -1
 * 59004
 */

public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        long prod = 1L;
        long sum = 0L;

        while(n > 0) {
            int last = n % 10;
            prod *= last;
            sum += last;
            n /= 10;
        }

        return (int) (prod - sum);
    }

    public static void main(String[] args) {
        System.out.println(new SubtractProductAndSum().subtractProductAndSum(234));
        System.out.println(new SubtractProductAndSum().subtractProductAndSum(4421));
        System.out.println(new SubtractProductAndSum().subtractProductAndSum(1));
        System.out.println(new SubtractProductAndSum().subtractProductAndSum(100000));
        System.out.println(new SubtractProductAndSum().subtractProductAndSum(99999));
    }
}

