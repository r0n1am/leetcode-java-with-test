package q191;

/**
 * <p>191. Number of 1 Bits</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/number-of-1-bits/">
 *         https://leetcode.com/problems/number-of-1-bits/
 *       </a>
 * </p>
 */
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        do {
            if ((1 & n) == 1) {
                cnt++;
            }
            n = n >>> 1;
        } while (n > 0);
        return cnt;
    }
}