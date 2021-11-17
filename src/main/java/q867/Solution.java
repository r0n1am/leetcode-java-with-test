package q867;

/**
 * <p>867. Transpose Matrix</p>
 * <p>
 *     See <a href="https://leetcode.com/problems/transpose-matrix/">
 *           https://leetcode.com/problems/transpose-matrix/
 *         </a>
 * </p>
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}