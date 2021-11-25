package q905;

/**
 * <p>905. Sort Array By Parity</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/sort-array-by-parity/">
 *         https://leetcode.com/problems/sort-array-by-parity/
 *       </a>
 * </p>
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[left] % 2 == 0 && left < nums.length - 1) {
                ++left;
            }
            while (nums[right] % 2 == 1 && right > 0) {
                --right;
            }
            if (left >= right) {
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left;
            --right;
        }
        return nums;
    }
}