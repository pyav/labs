/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Output:
 * ------
 * example good a
 * world hello
 * hello
 * blue is sky the
 */

public class ReverseWordsInString {

    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        String result = "";
        for (int i = len-1; i >= 0;) {
            int j = i;
            int k = i;
            while(j > -1 && s.charAt(j) != ' ') {
                j--;
            }
            if (j == -1) {
                result += s.substring(0, k+1);
            } else {
                result += s.substring(j+1, k+1);
            }
            while(j > -1 && s.charAt(j) == ' ') {
                j--;
            }
            if(j > -1) {
                result += ' ';
            }
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        String input1 = "a good   example";
        System.out.println(new ReverseWordsInString().reverseWords(input1));
        String input2 = "  hello   world  ";
        System.out.println(new ReverseWordsInString().reverseWords(input2));
        String input3 = "hello";
        System.out.println(new ReverseWordsInString().reverseWords(input3));
        String input4 = "the sky is blue";
        System.out.println(new ReverseWordsInString().reverseWords(input4));
    }

}

