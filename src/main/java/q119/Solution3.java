package q119;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>119. Pascal's Triangle II</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/pascals-triangle-ii/">
 *         https://leetcode.com/problems/pascals-triangle-ii/
 *       </a>
 * </p>
 * <p>
 *   This solution is O(n) in time with O(rowIndex + 1) in space,
 *   i.e. using only <code>rowIndex</code> extra space.
 * </p>
 * <p><b>no test temporarily since the test before this solution use this algorithm to verify the result</b></p>
 */
class Solution3 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex+1);
        //use long for prevent overflow
        //ok for the question upper bound
        //use BigInteger for arbitrary precision
        long val = 1;
        result.add((int)val);

        for (int i = 1; i <= rowIndex; ++i) {
            //by coefficient law, the terms could be calculated by
            //multiplying the previous term with (rowIndex - i + 1) / i
            //mini-proof:
            //c(1) = 1, c(2) = rowIndex = rowIndex/(1!)
            //c(3) = (rowIndex-1)*rowIndex/(2!) = (rowIndex/(1!)) * ((rowIndex-2+1)/2) = c(2) * ((rowIndex-2+1)/2)
            val = val * (rowIndex - i + 1) / i;
            result.add((int)val);
        }

        return result;
    }
}