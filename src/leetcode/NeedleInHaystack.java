/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 * Output:
 * ------
 * 0
 * -1
 * -1
 * -1
 * 0
 * 4
 */

public class NeedleInHaystack {
    public int strStr(String haystack, String needle) {
        int pos = -1;
        for (int i = 0; i <= haystack.length()-needle.length();) {
            int idx = i;
            boolean mismatch = false;
            int j = 0;
            for (; j < needle.length();) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    mismatch = true;
                    break;
                } else {
                    i++;
                    j++;
                }
            }
            if (mismatch) {
                i = idx+1;
                continue;
            }
            pos = idx;
            break;
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(new NeedleInHaystack().strStr("sadbutsad", "sad"));
        System.out.println(new NeedleInHaystack().strStr("leetcode", "leeto"));
        System.out.println(new NeedleInHaystack().strStr("leeto", "leetcode"));
        System.out.println(new NeedleInHaystack().strStr("l", "e"));
        System.out.println(new NeedleInHaystack().strStr("l", "l"));
        System.out.println(new NeedleInHaystack().strStr("mississippi", "issipp"));
    }
}

