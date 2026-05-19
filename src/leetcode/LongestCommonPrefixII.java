/**
 * https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Output:
 * ------
 * fl
 *
 */

public class LongestCommonPrefixII {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String tmp = "";
            int j = 0;

            for (; j < Math.min(strs[i].length(), result.length()); j++) {
                if (strs[i].charAt(j) == result.charAt(j)) {
                    tmp += String.valueOf(strs[i].charAt(j));
                } else {
                    break;
                }
            }
            result = tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefixII().longestCommonPrefix(strs));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(new LongestCommonPrefixII().longestCommonPrefix(strs2));
    }
}

