package q152;

/**
 * <p>152. Maximum Product Subarray</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/maximum-product-subarray/">
 *         https://leetcode.com/problems/maximum-product-subarray/
 *       </a>
 * </p>
 */
class Solution {
    public int maxProduct(int[] nums) {
        int globalMaxProduct = nums[0];
        int globalMinProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int currMultiplyMax = globalMaxProduct * nums[i];
            int currMultiplyMin = globalMinProduct * nums[i];

            // min and max for current position
            int localMinProduct = Math.min(nums[i], Math.min(currMultiplyMax, currMultiplyMin));
            globalMaxProduct = Math.max(nums[i], Math.max(currMultiplyMax, currMultiplyMin));
            globalMinProduct = localMinProduct;

            // product
            result = Math.max(result, globalMaxProduct);
        }
        return result;
    }
}