/**
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings/
 *
 * Output:
 * ------
 * 5 4 3 2 
 * 4
 */

import java.util.Arrays;

class Node {
    private static final int childCount = 26;
    boolean isEndOfWord = false;
    int count = 0;
    Node[] child = null;

    Node() {
        child = new Node[childCount];
        for (int i = 0; i < childCount; i++) {
            child[i] = null;
        }
        isEndOfWord = false;
    }

    public void addWord(String word) {
        Node tmp = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (null == tmp.child[index]) {
                tmp.child[index] = new Node();
            }
            tmp.child[index].count++;
            tmp = tmp.child[index];
        }
        tmp.isEndOfWord = true;
    }
}

public class SumPrefixScores {
    Node node = new Node();

    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            node.addWord(word);
        }
        int[] result = new int[words.length];
        for (int j = 0; j < words.length; j++) {
            int val = 0;
            Node tmp = node;

            for (int i = 0; i < words[j].length(); i++) {
                int idx = words[j].charAt(i) - 'a';
                val += tmp.child[idx].count;
                tmp = tmp.child[idx];
            }
            result[j] = val;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result1 = new SumPrefixScores().sumPrefixScores(new String[]{"abc", "ab", "bc", "b"});
        Arrays.stream(result1).forEach(val -> System.out.printf("%d ", val));
        System.out.println();
        int[] result2 = new SumPrefixScores().sumPrefixScores(new String[]{"abcd"});
        Arrays.stream(result2).forEach(val -> System.out.printf("%d ", val));
        System.out.println();
    }
}

