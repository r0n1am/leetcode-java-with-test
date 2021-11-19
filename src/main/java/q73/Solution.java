package q73;

/**
 * <p>73. Set Matrix Zeroes</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/set-matrix-zeroes/">
 *         https://leetcode.com/problems/set-matrix-zeroes/
 *       </a>
 * </p>
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowSetZero = false;

        int rowLength = matrix[0].length;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < rowLength; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        isFirstRowSetZero = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                    matrix[0][j] = 0;
                }
            }
        }

        // set row to zero first
        // set column first will mess up the indicators for rows
        // don't set the first row yet, will do it in last step
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < rowLength; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        //set column to zero
        for (int j = 0; j < rowLength; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }

        //lastly set the first row to zero if needed
        if (isFirstRowSetZero) {
            for (int i = 0; i < rowLength; ++i) {
                matrix[0][i] = 0;
            }
        }

        System.gc();
    }
}