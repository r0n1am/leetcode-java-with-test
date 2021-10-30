package q119;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II<br/>
 * See <a herf="https://leetcode.com/problems/pascals-triangle-ii/">
 *       https://leetcode.com/problems/pascals-triangle-ii/
 *     </a><br/>
 *
 * This solution is O(n<sup>2</sup>) in time with O(<code>rowIndex</code> + <code>rowIndex</code> + 1) in space<br/>
 * i.e. using 2 <code>rowIndex</code> extra space<br/>
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> previousInts = new ArrayList<>();
        previousInts.add(1);
        if (rowIndex == 0) {
            return previousInts;
        }

        for (int i = 1; i <= rowIndex; ++i) {
            List<Integer> ints = new ArrayList<>();
            ints.add(1);

            for (int j = 0; j < previousInts.size() - 1; ++j) {
                ints.add(previousInts.get(j) + previousInts.get(j+1));
            }
            ints.add(1);

            previousInts = ints;
        }
        return previousInts;
    }
}