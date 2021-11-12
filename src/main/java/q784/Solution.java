package q784;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>784. Letter Case Permutation</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/letter-case-permutation/">
 *         https://leetcode.com/problems/letter-case-permutation/
 *       </a>
 * </p>
 */
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> results = new ArrayList<>();
        letterCasePermutation(results, s, new StringBuilder(), 0);
        return results;
    }

    private void letterCasePermutation(
        List<String> results,
        String s,
        StringBuilder sb,
        int currentPos
    ) {
        if (currentPos >= s.length()) {
            results.add(sb.toString());
            return;
        }
        char c = s.charAt(currentPos);
        sb.append(c);
        letterCasePermutation(results, s, sb, currentPos + 1);
        sb.setLength(currentPos+1);

        if (c >= 'A' && c <= 'Z') {
            sb.setCharAt(currentPos, (char)(c + 32));
            letterCasePermutation(results, s, sb, currentPos + 1);
        } else if (c >= 'a' && c <= 'z') {
            sb.setCharAt(currentPos, (char)(c - 32));
            letterCasePermutation(results, s, sb, currentPos + 1);
        }
    }
}