package q1287;

/**
 * <p>1287. Element Appearing More Than 25% In Sorted Array</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/">
 *         https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *       </a>
 * </p>
 */
class Solution {
    public int findSpecialInteger(int[] arr) {
        int target = arr.length / 4;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == arr[i+target]) {
                return arr[i];
            }
        }
        //should not happened
        return -1;
    }
}