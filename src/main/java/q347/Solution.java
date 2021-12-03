package q347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>347. Top K Frequent Elements</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/top-k-frequent-elements/">
 *        https://leetcode.com/problems/top-k-frequent-elements/
 *       </a>
 * </p>
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q =
            new PriorityQueue<>(nums.length, Map.Entry.<Integer, Integer>comparingByValue().reversed());
        q.addAll(map.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = q.poll().getKey();
        }
        return result;
    }
}
