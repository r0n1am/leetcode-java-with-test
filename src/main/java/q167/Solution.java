package q167;

/**
 * <p>167. Two Sum II - Input Array Is Sorted</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">
 *         https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *       </a>
 * </p>
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length-1;

        while(start < end){
            int diff = numbers[start] + numbers[end] - target;

            if(diff == 0){
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            } else if(diff > 0){
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}