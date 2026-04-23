/**
 * https://leetcode.com/problems/reverse-words-with-same-vowel-count/ 
 * 
 * Output:
 * ------
 * cat dna mice
 * book is ecin
 * banana healthy
 * b
 */

public class ReverseSameVowelCountWords {
	
	private int getVowelCount(String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char t = s.charAt(i);
			
			if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
				count++;
			}
		}
		
		return count;
	}
	
	public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int countVowelInFirstWord = getVowelCount(arr[0]);
        
        StringBuilder sb = new StringBuilder();
        String result = "";
        result += arr[0];
        
        for (int i = 1; i < arr.length; i++) {
        	if (getVowelCount(arr[i]) == countVowelInFirstWord) {
        		sb.append(arr[i]);
        		sb.reverse();
        		arr[i] = sb.toString();
        		sb.delete(0, sb.length());
        		result += " " + arr[i];
        	} else {
        		result += " " + arr[i];
        	}
        }
        
        return result;
    }

	public static void main(String[] args) {
		System.out.println(new ReverseSameVowelCountWords().reverseWords("cat and mice"));
		System.out.println(new ReverseSameVowelCountWords().reverseWords("book is nice"));
		System.out.println(new ReverseSameVowelCountWords().reverseWords("banana healthy"));
		System.out.println(new ReverseSameVowelCountWords().reverseWords("b"));
	}

}
