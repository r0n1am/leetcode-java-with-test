package q980;

/**
 * <p>980. Unique Paths III</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/unique-paths-iii/">
 *         https://leetcode.com/problems/unique-paths-iii/
 *       </a>
 * </p>
 * <p>It is my second attempt on solving the problem, which is modifying the input grid</p>
 */
class Solution2 {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int target = 1;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j ) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    ++target;
                }
            }
        }
        return uniquePaths(grid, startX, startY, target);
    }

    private int uniquePaths(int[][] grid, int currentX, int currentY, int step) {
        if (currentX < 0 || currentY < 0 || // out of boundary
            currentX >= grid.length || currentY >= grid[currentX].length || // out of boundary
            grid[currentX][currentY] == -1 // obstacles or visited
        ) {
            return 0;
        }
        if (grid[currentX][currentY] == 2) {
            return step == 0 ? 1 : 0;
        }

        //check result
        grid[currentX][currentY] = -1; // visited, mark it as obstacles

        int result =
            uniquePaths(grid, currentX + 1, currentY, step-1) + // right cell
            uniquePaths(grid, currentX, currentY + 1, step-1) + // upper cell
            uniquePaths(grid, currentX - 1, currentY, step-1) + // left cell
            uniquePaths(grid, currentX, currentY - 1, step-1);  // lower cell

        grid[currentX][currentY] = 0; // mark it back to unvisited

        return result;
    }
}