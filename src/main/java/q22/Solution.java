package q22;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>22. Generate Parentheses</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/generate-parentheses/">
 *         https://leetcode.com/problems/generate-parentheses/
 *       </a>
 * </p>
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generateParenthesis(results, new char[n*2], 0, 0, n);
        return results;
    }

    private void generateParenthesis(
        List<String> results,
        char[] sb,
        int openedCount,
        int closedCount,
        int target
    ) {
        if (closedCount == target) {
            results.add(new String(sb));
            return;
        }
        if (openedCount < target) {
            sb[openedCount + closedCount] = '(';
            generateParenthesis(results, sb, openedCount + 1, closedCount, target);
        }
        if (closedCount < openedCount) {
            sb[openedCount + closedCount] = ')';
            generateParenthesis(results, sb, openedCount, closedCount + 1, target);
        }
    }
}