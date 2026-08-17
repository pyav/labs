/**
 * https://leetcode.com/problems/string-compression/description
 *
 * Output:
 * ------
 * 6
 * 1
 * 4
 */

public class StringCompression {
    public int compress(char[] chars) {
        int start = 0;
        int end = 0;
        int write = 0;

        while (start < chars.length) {
            end = start;

            while (end + 1 < chars.length && chars[end + 1] == chars[start]) {
                end++;
            }

            int count = end - start + 1;

            chars[write++] = chars[start];

            if (count > 1) {
                String countString = String.valueOf(count);

                for (char c : countString.toCharArray()) {
                    chars[write++] = c;
                }
            }

            start = end + 1;
        }

        return write;
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(new StringCompression().compress(new char[]{'a'}));
        System.out.println(new StringCompression().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }
}

