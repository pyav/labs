/**
 * https://leetcode.com/problems/to-lower-case/
 *
 * Output:
 * ------
 * aabb
 * a
 * tttty
 */

public class ToLowerCase {

    public String toLowerCase(String s) {
        String result = "";
        for (int i = 0 ; i < s.length(); i++) {
            int val = s.charAt(i) - 'A';
            if (val >= 0 && val <= 25) {
                result += (char) (val + 'a');
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("AaBb"));
        System.out.println(new ToLowerCase().toLowerCase("a"));
        System.out.println(new ToLowerCase().toLowerCase("TTTTY"));
    }

}

