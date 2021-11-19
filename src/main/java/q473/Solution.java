package q473;

import java.util.Arrays;

/**
 * <p>473. Matchsticks to Square</p>
 * <p>
 *     See <a href="https://leetcode.com/problems/matchsticks-to-square/">
 *           https://leetcode.com/problems/matchsticks-to-square/
 *         </a>
 * </p>
 */
class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        //fast false
        int total = 0;
        for (int match : matchsticks) {
            total += match;
        }
        if (total % 4 != 0) {
            return false;
        }
        return makesquare(matchsticks, 0, new int[4], total / 4);
    }

    private int[] reverse(int[] matchsticks) {
        for (int i = 0; i < matchsticks.length / 2; ++i) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - i - 1];
            matchsticks[matchsticks.length - i - 1] = temp;
        }
        return matchsticks;
    }

    private boolean makesquare(int[] matchsticks, int curr, int[] sides, int target) {
        if (curr == matchsticks.length) {
            return sides[0] == target  && sides[1]  == target && sides[2] == target && sides[3] == target;
        }
        for (int i = 0; i < 4; ++i) {
            int addedSum = sides[i] + matchsticks[curr];
            if (addedSum > target || (i > 0 && sides[i] == sides[i-1])) {
                continue;
            }
            sides[i] = addedSum;
            if (makesquare(matchsticks, curr + 1, sides, target)) {
                return true;
            }
            sides[i] -= matchsticks[curr];
        }
        return false;
    }
}