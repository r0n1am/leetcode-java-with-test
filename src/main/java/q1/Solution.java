package q1;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1. Two Sum</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/two-sum/">
 *         https://leetcode.com/problems/two-sum/
 *       </a>
 * </p>
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> targetMap = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int targetIdx = targetMap.getOrDefault(target - nums[i], -1);

            if(targetIdx > -1){
                result[0] = targetIdx;
                result[1] = i;
                break;
            }
            targetMap.put(nums[i], i);
        }
        return result;
    }
}