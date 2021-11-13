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
        generateParenthesis(results, new StringBuilder(), 0, 0, n);
        return results;
    }

    private void generateParenthesis(
        List<String> results,
        StringBuilder sb,
        int openedCount,
        int closedCount,
        int target
    ) {
        if (closedCount == target) {
            results.add(sb.toString());
            return;
        }
        int currLength = sb.length();
        if (openedCount < target) {
            sb.append("(");
            generateParenthesis(results, sb, openedCount + 1, closedCount, target);
            sb.setLength(currLength);
        }
        if (closedCount < openedCount) {
            sb.append(")");
            generateParenthesis(results, sb, openedCount, closedCount + 1, target);
        }
    }
}