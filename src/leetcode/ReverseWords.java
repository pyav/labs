/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description
 * 
 * Output:
 * ------
 * s'teL ekat edoCteeL tsetnoc
 * rM gniD
 */

public class ReverseWords {
	
	public String reverseWords(String s) {
        String[] splitArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < splitArr.length; i++) {
        	StringBuilder tmpSb = new StringBuilder();
        	tmpSb.append(splitArr[i]);
        	tmpSb.reverse();
        	sb.append(tmpSb.toString() + " ");
        }
        String resultStr = sb.toString();
        return resultStr.substring(0, resultStr.length()-1);
    }

	public static void main(String[] args) {
		System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
		System.out.println(new ReverseWords().reverseWords("Mr Ding"));
	}

}
