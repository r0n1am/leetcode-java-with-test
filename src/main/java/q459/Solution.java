package q459;

/**
 * 459. Repeated Substring Pattern <br/>
 * See <a herf="https://leetcode.com/problems/repeated-substring-pattern/">
 *       https://leetcode.com/problems/repeated-substring-pattern/
 *     </a>
 *  Performance is not good.
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if (length > 1) {
            for (int i = 0; i < length / 2; ++i) {
                String searchString = s.substring(0, i + 1);
                if (length % searchString.length() == 0 &&
                    s.replace(searchString, "").length() == 0
                ) {
                    return true;
                }
            }
        }
        return false;
    }
}
