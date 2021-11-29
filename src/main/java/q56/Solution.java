package q56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>56. Merge Intervals</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/merge-intervals/">
 *        https://leetcode.com/problems/merge-intervals/
 *       </a>
 * </p>
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, this::compare);

        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[0][0]);
    }

    private int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0];
    }
}