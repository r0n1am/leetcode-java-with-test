package q136;

/**
 * <p>136. Single Number</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/single-number/">
 *         https://leetcode.com/problems/single-number/
 *       </a>
 * </p>
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}