package q1032;

import java.util.*;

/**
 * <p>1032. Stream of Characters</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/stream-of-characters/">
 *         https://leetcode.com/problems/stream-of-characters/
 *       </a>
 * </p>
 */
class ReverseStreamChecker {

    class Node {
        final Node[] links = new Node[26];
        boolean isWord;
    }

    final Node root = new Node();
    Deque<Character> buffer = new ArrayDeque<>(2000);

    public ReverseStreamChecker(String[] words) {
        for (String word : words) {
            Node curr = root;
            for (int i = word.length() - 1; i >= 0; --i) {
                if (curr.links[word.charAt(i) - 'a'] == null) {
                    curr.links[word.charAt(i) - 'a'] = new Node();
                }
                curr = curr.links[word.charAt(i) - 'a'];
            }
            curr.isWord = true;
        }
    }

    public boolean query(char letter) {
        buffer.addFirst(letter);

        Node curr = root;
        for (char c : buffer) {
            if (curr.isWord) {
                return true;
            }
            curr = curr.links[c - 'a'];
            if (curr == null) {
                return false;
            }
        }
        return curr.isWord;
    }
}
