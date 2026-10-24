/**
 * https://leetcode.com/problems/reverse-prefix-of-word/
 *
 * Output:
 * ------
 * dcbaefd
 * zxyxxe
 * abcd
 */

public class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        int pos = word.indexOf(ch);
        if (-1 == pos) {
            return word;
        }
        return new StringBuilder().append(word.substring(0, pos+1)).reverse().toString() + 
            new StringBuilder().append(word.substring(pos+1, word.length())).toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReversePrefix().reversePrefix("abcdefd", 'd'));
        System.out.println(new ReversePrefix().reversePrefix("xyxzxe", 'z'));
        System.out.println(new ReversePrefix().reversePrefix("abcd", 'z'));
    }
}

