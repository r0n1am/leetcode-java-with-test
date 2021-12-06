package q1557;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1557. Minimum Number of Vertices to Reach All Nodes</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">
 *         https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 *       </a>
 * </p>
 */
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inCnts = new int[n];
        for (List<Integer> edge : edges) {
            inCnts[edge.get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (inCnts[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
