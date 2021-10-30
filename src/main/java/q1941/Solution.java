package q1941;

/**
 * 1941. Check if All Characters Have Equal Number of Occurrences<br/>
 * See <a herf="https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/">
 *       https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 *     </a><br/>
 */
public class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] results = new int[26];
        
        for (char c : s.toCharArray()) {
            results[c - 97]++;
        }
        
        int temp = -1;
        for (int count : results) {
            if (count != 0 && temp == -1) {
                temp = count;
            } else if (count != 0 && count != temp) {
                return false;
            }
        }
        return true;
    }
}