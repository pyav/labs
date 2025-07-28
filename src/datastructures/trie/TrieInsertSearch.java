/**
 * This program shows 'insert' and 'search' operations in a Trie.
 *
 * Output:
 * ------
 * true
 * false
 * true
 * true
 * false
 */

public class TrieInsertSearch {

    private static int childrenCount = 26;

    static class Node {
        Node[] child = new Node[TrieInsertSearch.childrenCount];
        boolean isEndOfWord;
        Node() {
            for (int i = 0; i < child.length; i++) {
                child[i] = null;
            }
            isEndOfWord = false;
        }
    }

    public void insert(String key, Node node){ 
        if (null == node) {
            System.out.println("ERROR: node is null");
            return;
        }
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (null == node.child[index]) {
                node.child[index] = new Node();
            }
            node = node.child[index];
        }
        node.isEndOfWord = true;
    }

    public boolean isPresent(String key, Node node) {
        if (null == node) {
            return false;
        }
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        Node root = new Node();
        String[] sampleSpace = {"my", "name", "is", "pyav"};
        String[] query = {"is", "the", "name", "pyav", "mine"};
        TrieInsertSearch trieObj = new TrieInsertSearch();
        for (int i = 0; i < sampleSpace.length; i++) {
            trieObj.insert(sampleSpace[i], root);
        }
        for (int i = 0; i < query.length; i++) {
            System.out.println(trieObj.isPresent(query[i], root));
        }
    }

}

