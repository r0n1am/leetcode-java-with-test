package q1032;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1032. Stream of Characters</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/stream-of-characters/">
 *         https://leetcode.com/problems/stream-of-characters/
 *       </a>
 * </p>
 */
class StreamChecker {

    class Node {
        final Node[] links = new Node[26];
        boolean isWord;
    }

    final Node root = new Node();
    List<Node> trackingNodes = new ArrayList<>();

    public StreamChecker(String[] words) {
        for (String word : words) {
            Node curr = root;
            for (int i = 0; i < word.length(); ++i) {
                if (curr.links[word.charAt(i) - 'a'] == null) {
                    curr.links[word.charAt(i) - 'a'] = new Node();
                }
                curr = curr.links[word.charAt(i) - 'a'];
            }
            curr.isWord = true;
        }
    }

    public boolean query(char letter) {
        boolean hit = false;

        List<Node> newTrackingNodes = new ArrayList<>();

        trackingNodes.add(root);
        for  (Node node : trackingNodes) {
            Node temp = node.links[letter - 'a'];
            if (temp != null) {
                hit = hit || temp.isWord;
                newTrackingNodes.add(temp);
            }
        }

        trackingNodes = newTrackingNodes;
        return hit;
    }
}
