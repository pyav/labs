/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 *
 * Output:
 * ------
 * 1[.]1[.]1[.]1
 * 255[.]100[.]50[.]0
 */

public class DefangIP {

    public String defangIPaddr(String address) {
        String result = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                result += "[.]";
            } else {
                result += address.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DefangIP().defangIPaddr("1.1.1.1"));
        System.out.println(new DefangIP().defangIPaddr("255.100.50.0"));
    }

}

