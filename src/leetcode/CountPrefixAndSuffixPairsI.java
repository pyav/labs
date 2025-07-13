/**
 * https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/
 *
 * Output:
 * ------
 * 2
 * 0
 * 1
 * 0
 * 0
 * 0
 * 0
 * 1
 * 4
 */

import java.util.ArrayList;
import java.util.List;

class Node {
    Node[] child;
    boolean isEndOfWord;
    List<Integer> idx = new ArrayList<>();

    Node() {
        child = new Node[27];
        for (int i = 0; i < child.length; i++) {
            child[i] = null;
        }
        isEndOfWord = false;
    }

    public void addWord(String word, int idx) {
        Node tmp = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (null == tmp.child[index]) {
                tmp.child[index] = new Node();
            }
            tmp = tmp.child[index];
            tmp.idx.add(idx);
        }
        tmp.isEndOfWord = true;
    }

    public List<Integer> getIndexes(String word) {
        Node tmp = this;
        for (int i = 0; i < word.length(); i++) {
            tmp = tmp.child[word.charAt(i) - 'a'];
        }
        return tmp.idx;
    }
}

public class CountPrefixAndSuffixPairsI {
    Node node = new Node();

    public long countPrefixSuffixPairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String updatedWord = words[i] + "{" + words[i];
            for (int j = 0; updatedWord.charAt(j) != '{'; j++) {
                node.addWord(updatedWord.substring(j, updatedWord.length()), i);
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String updatedWord = words[i] + "{" + words[i];
            List<Integer> idxList = node.getIndexes(updatedWord);
            result += idxList.size() - idxList.indexOf(i)  - 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"pa","papa","ma","mama"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"abab", "ab"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"a", "a"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"a", "b"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"a", "ba"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"a", "ac", "cba"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"ad", "ac", "cba"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"a", "aa"}));
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[] {"a","aba","ababa","aa"}));
        }
}

