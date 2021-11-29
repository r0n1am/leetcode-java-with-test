package q2091;

/**
 * <p>2091. Removing Minimum and Maximum From Array</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/removing-minimum-and-maximum-from-array/">
 *         https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 *       </a>
 * </p>
 */
class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int maxIndex = 0;
        int minIndex = 0;
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            } else if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }
        return Math.min(minIndex + 1 + nums.length - maxIndex, Math.min(maxIndex + 1, nums.length - minIndex));
    }
}