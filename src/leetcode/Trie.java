/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Output:
 * ------
 * true
 * false
 * true
 * true
 */

package leetcode;

public class Trie {

    private static int childrenCount = 26;
    static class Node {
        Node[] child = new Node[childrenCount];
        boolean isEndOfWord;
        Node() {
            for (int i = 0; i < child.length; i++) {
                child[i] = null;
            }
            isEndOfWord = false;
        }
    }
    private static Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (null == node.child[index]) {
                node.child[index] = new Node();
            }
            node = node.child[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }

}

