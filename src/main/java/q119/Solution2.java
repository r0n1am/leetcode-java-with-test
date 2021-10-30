package q119;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 119. Pascal's Triangle II<br/>
 * See <a herf="https://leetcode.com/problems/pascals-triangle-ii/">
 *       https://leetcode.com/problems/pascals-triangle-ii/
 *     </a><br/>
 * This solution is O(n<sup>2</sup>) in time with O(rowIndex + 1) in space<br/>
 * i.e. using only <code>rowIndex</code> extra space
 */
class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> result = new LinkedList<>();
        result.add(1);

        for (int i = 1; i <= rowIndex; ++i) {
            ListIterator<Integer> iter = result.listIterator();
            int prev = iter.next();
            while (iter.hasNext()) {
                // add prev to next value, while assigning the next value to prev
                iter.set(prev + (prev = iter.next()));
            }
            result.add(1);
        }

        return result;
    }
}