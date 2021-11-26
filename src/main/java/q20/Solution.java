package q20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>20. Valid Parentheses</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/valid-parentheses/">
 *         https://leetcode.com/problems/valid-parentheses/
 *       </a>
 * </p>
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> open = new ArrayDeque<>();

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '[') {
                open.push(c);
            } else {
                Character openParen = open.peek();
                if (openParen == null ||
                    (c == ')' && openParen != '(') ||
                    (c == '}' && openParen != '{') ||
                    (c == ']' && openParen != '[')
                ) {
                    return false;
                }
            }
        }
        return open.isEmpty();
    }
}