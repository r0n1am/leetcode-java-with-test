package q217;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * See <a herf="https://leetcode.com/problems/contains-duplicate/">https://leetcode.com/problems/contains-duplicate/</a>
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}