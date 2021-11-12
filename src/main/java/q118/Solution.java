package q118;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>118. Pascal's Triangle</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/pascals-triangle/">
 *         https://leetcode.com/problems/pascals-triangle/
 *       </a>
 * </p>
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        result.add(ints);

        for (int i = 1; i < numRows; ++i) {
            ints = new ArrayList<>();
            ints.add(1);

            List<Integer> previousInts = result.get(i - 1);
            for (int j = 0; j < previousInts.size() - 1; ++j) {
                ints.add(previousInts.get(j) + previousInts.get(j+1));
            }
            ints.add(1);

            result.add(ints);
        }
        return result;
    }
}