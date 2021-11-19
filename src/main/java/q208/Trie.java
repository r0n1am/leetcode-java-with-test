package q208;

/**
 * <p>208. Implement Trie (Prefix Tree)</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">
 *         https://leetcode.com/problems/implement-trie-prefix-tree/
 *       </a>
 * </p>
 */
class Trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        final char value;
        boolean isWholeWord = false;

        TrieNode(char value) {
            this.value = value;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            TrieNode temp = node.children[index];
            if (temp == null) {
                node = node.children[index] = new TrieNode(c);
            } else {
                node = temp;
            }
        }
        node.isWholeWord = true;
    }
    
    public boolean search(String word) {
        TrieNode lastNode = lastNodeForString(word);
        return lastNode != null && lastNode.isWholeWord;
    }
    
    public boolean startsWith(String prefix) {
        return lastNodeForString(prefix) != null;
    }

    private TrieNode lastNodeForString(String s) {
        TrieNode lastNode = root;
        for (char c : s.toCharArray()) {
            lastNode = lastNode.children[c - 'a'];
            if (lastNode == null) {
                break;
            }
        }
        return lastNode;
    }
}