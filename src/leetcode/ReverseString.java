/**
 * https://leetcode.com/problems/reverse-string/
 *
 * Output:
 * ------
 * o l l e h 
 * h a n n a H 
 */

public class ReverseString {

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len/2; i++) {
            char tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] input = {'h','e','l','l','o'};
        new ReverseString().reverseString(input);
        for (char val : input) {
            System.out.printf("%c ", val);
        }
        System.out.println();
        char[] input2 = {'H','a','n','n','a','h'};
        new ReverseString().reverseString(input2);
        for (char val : input2) {
            System.out.printf("%c ", val);
        }
        System.out.println();
    }

}

