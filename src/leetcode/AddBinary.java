/**
 * https://leetcode.com/problems/add-binary/description/
 *
 * Output:
 * ------
 * 100
 * 10101
 * 1100000000000000000000000000000000000000000000000011111111111111111111111111111111001
 */

public class AddBinary {

    public String addBinary(String a, String b) {
        String low = a;
        int lowLen = a.length();
        String high = b;
        int highLen = b.length();

        if (highLen < lowLen) {
            lowLen = b.length();
            low = b;
            highLen = a.length();
            high = a;
        }
        
        int carry = 0;
        String sum = "";

        for (int i = 0; i < lowLen; i++) {
            int val = (low.charAt(lowLen-i-1)-'0') + (high.charAt(highLen-i-1)-'0') + carry;
            carry = val/2;
            sum = String.valueOf(val%2) + sum;
        }
        int balance = highLen - lowLen;
        if (balance == 0 && carry > 0) {
            sum = String.valueOf(carry) + sum;
        } else if (balance == 0 && carry == 0) {
        } else {
            for (int i = 0; i < balance; i++) {
                int val = (carry > 0)? carry + (high.charAt(balance-i-1)-'0'):
                                        high.charAt(balance-i-1)-'0';
                carry = val/2;
                sum = String.valueOf(val%2) + sum;
            }
            if (carry > 0) {
            	sum = String.valueOf(carry) + sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
        System.out.println(new AddBinary().addBinary("1010", "1011"));
        System.out.println(new
        AddBinary().addBinary("11111111111111111111111111111111010",
        "1011111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
    }

}

