/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Output:
 * ------
 * holle
 * leotcede
 * anAnd
 */

public class ReverseVowels {

    private boolean isVowel(char s) {
        if (s == 'a' || s == 'A' || s == 'e' || s == 'E' || s == 'i' ||
            s == 'I' || s == 'o' || s == 'O' || s == 'u' || s == 'U') {
            return true;
        }
        return false;
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        String s1 = "";
        String s2 = "";

        while(i <= j) {
            if (i == j) {
                s1 = s1 + s.charAt(i);
                i++;
                j--;
                continue;
            }
            if (isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                s1 = s1 + s.charAt(j);
                s2 = s.charAt(i) + s2;
                i++;
                j--;
                continue;
            }
            if (!isVowel(s.charAt(i))) {
                s1 += s.charAt(i);
                i++;
            }
            if (!isVowel(s.charAt(j))) {
                s2 = s.charAt(j) + s2;
                j--;
            }
        }

        return s1+s2;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("hello"));
        System.out.println(new ReverseVowels().reverseVowels("leetcode"));
        System.out.println(new ReverseVowels().reverseVowels("Anand"));
    }

}

