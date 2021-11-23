package q724;

/**
 * <p>724. Find Pivot Index</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/find-pivot-index/">
 *         https://leetcode.com/problems/find-pivot-index/
 *       </a>
 * </p>
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int left = 0;
        for (int i = 0; i < nums.length; ++i) {
            total -= nums[i];
            if (left == total) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }
}