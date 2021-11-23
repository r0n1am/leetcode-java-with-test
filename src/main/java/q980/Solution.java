package q980;

/**
 * <p>980. Unique Paths III</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/unique-paths-iii/">
 *         https://leetcode.com/problems/unique-paths-iii/
 *       </a>
 * </p>
 * <p>It is my first attempt on solving the problem, which is not modifying the input grid</p>
 */
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int[] visited = new int[grid.length];
        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[x].length; ++y) {
                if (grid[x][y] == 1) {
                    startX = x;
                    startY = y;
                } else if (grid[x][y] == -1) {
                    visited[x] |= 1 << y;// obstacles = visited
                }
            }
        }
        return uniquePaths(grid, startX, startY, visited);
    }

    private int uniquePaths(int[][] grid, int currX, int currY, int[] visited) {
        if (currX < 0 || currY < 0 || // out of boundary
            currX >= grid.length || currY >= grid[currX].length || // out of boundary
            ((visited[currX] >>> currY) & 1) == 1 // obstacles or visited
        ) {
            return 0;
        }

        visited[currX] |= 1 << currY; // set visited flag
        int result = 0;
        if (grid[currX][currY] == 2) {
            result = checkAllVisited(grid, visited) ? 1 : 0;
        } else {
            result =
                uniquePaths(grid, currX - 1, currY, visited) + // check left cell
                uniquePaths(grid, currX, currY - 1, visited) + // check upper cell
                uniquePaths(grid, currX + 1, currY, visited) + // check right cell
                uniquePaths(grid, currX, currY + 1, visited);  // check lower cell
        }
        visited[currX] &= ~(1 << currY); // unset visited flag
        return result;
    }

    private boolean checkAllVisited(int[][] grid, int[] visited) {
        for (int row = 0; row < grid.length; ++row) {
            if (visited[row] != (1<<grid[row].length)-1) {
                return false;
            }
        }
        return true;
    }
}