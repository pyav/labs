/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/?envType=problem-list-v2&envId=string
 *
 * Output:
 * ------
 * false
 * true
 * true
 * true
 */

public class WordDictionary {

    private static int childrenCount = 26;

    class Node {
        Node[] child = new Node[childrenCount];
        boolean isEndOfWord;

        Node() {
            for (int i = 0; i < child.length; i++) {
                child[i] = null;
            }
            isEndOfWord = false;
        }
    }
    Node node = null;

    public WordDictionary() {
        node = new Node();
    }

    public void addWord(String word) {
        Node tmp = this.node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (null == tmp.child[index]) {
                tmp.child[index] = new Node();
            }
            tmp = tmp.child[index];
        }
        tmp.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, this.node);
    }
    private boolean search(String word, Node node) {
        if (null == node) {
            return false;
        }
        Node tmp = node;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < childrenCount; j++) {
                    if (tmp.child[j] != null && search(word.substring(i + 1), tmp.child[j])) {
                        return true;
                    }
                }
                return false;
            }
            int index = word.charAt(i) - 'a';
            if (tmp.child[index] == null) {
                return false;
            }
            tmp = tmp.child[index];
        }
        return tmp.isEndOfWord;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}

