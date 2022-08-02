/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Output:
 * -------
 * fl
 * 
 * py
 * 
 * aba
 * 
 */

package leetcode;

public class LongestCommonPrefix {
    static class Node {
        Node[] child = new Node[26];
        boolean isEndOfWord;
        Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            isEndOfWord = false;
        }
        public void insert(String key){ 
            Node node = this;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (null == node.child[index]) {
                    node.child[index] = new Node();
                }
                node = node.child[index];
            }
            node.isEndOfWord = true;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for (String val : strs) {
            if (val.length() == 0) {
                return "";
            }
            root.insert(val);
        }
        Node node = root;
        String finalStr = "";
        while(node != null) {
            int count = 0, k = 0, i = 0;
            for (; i < 26 && count < 2 && !node.isEndOfWord; i++) {
                if (null != node.child[i]) {
                    count++;
                    k = i;
                    finalStr += Character.toString('a' + i);
                }
            }
            if (node.isEndOfWord) {
                return finalStr;
            } else if (count == 2) {
                return finalStr.substring(0, finalStr.length()-2);
            } else if (count == 1) {
                node = node.child[k];
            } else {
                node = null;
            }
        }
        return finalStr;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs2));
        String[] strs3 = {"pyav", "python", "pyorg"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs3));
        String[] strs4 = {"b", ""};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs4));
        String[] strs5 = {"abaa", "aba"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs5));
    }

}

