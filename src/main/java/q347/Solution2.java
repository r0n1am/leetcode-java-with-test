package q347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *   This is a solution based on Bucket Sort, suggested by LeetCode user DBabichev in solution' comment section.
 * </p>
 */
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer>[] buckets = new ArrayList[nums.length];

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int index = nums.length - entry.getValue();

            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(num);
        }

        int[] result = new int[k];
        int i = 0;

        for (List<Integer> bucket: buckets) {
            if (bucket == null) {
                continue;
            }

            for (int num: bucket) {
                result[i++] = num;
                if (i == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
