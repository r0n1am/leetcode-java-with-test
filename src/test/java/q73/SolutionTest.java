package q73;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();
    static Random r = new Random();

    @Test
    void shouldSetZeroForSimpleArray() {
        int[][] input = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        int[][] expected = new int[][]{
            {1, 0, 1},
            {0, 0, 0},
            {1, 0, 1}
        };

        s.setZeroes(input);
        assertThat(input).isEqualTo(expected);
    }

    @Test
    void shouldSetZeroForCornerZeroArray() {
        int[][] input = new int[][]{
            {0, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] expected = new int[][]{
            {0, 0, 0},
            {0, 1, 1},
            {0, 1, 1}
        };

        s.setZeroes(input);
        assertThat(input).isEqualTo(expected);
    }

    @Test
    void shouldSetZeroForFirstRowZeroArray() {
        int[][] input = new int[][]{
            {1, 0, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] expected = new int[][]{
            {0, 0, 0},
            {1, 0, 1},
            {1, 0, 1}
        };

        s.setZeroes(input);
        assertThat(input).isEqualTo(expected);
    }

    @Test
    void shouldSetZeroForFirstColumnZeroArray() {
        int[][] input = new int[][]{
            {1, 1, 1},
            {0, 1, 1},
            {1, 1, 1}
        };

        int[][] expected = new int[][]{
            {0, 1, 1},
            {0, 0, 0},
            {0, 1, 1}
        };

        s.setZeroes(input);
        assertThat(input).isEqualTo(expected);
    }

    @RepeatedTest(50)
    void shouldSetDoNothingForArrayNotIncludeZero() {
        int m = r.nextInt(200) + 1;
        int n = r.nextInt(200) + 1;
        int[][] input = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                input[i][j] = r.nextInt() + 1;
                if (r.nextBoolean()) {
                    input[i][j] *= -1;
                }
            }
        }

        int[][] expected = Arrays.stream(input).map(int[]::clone).toArray(int[][]::new);

        s.setZeroes(input);
        assertThat(input).isEqualTo(expected);
    }

    @RepeatedTest(50)
    void shouldSetZeroForArrayIncludeZeroes() {
        int m = r.nextInt(200) + 1;
        int n = r.nextInt(200) + 1;
        int[][] input = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                input[i][j] = r.nextInt() + 1;
                if (r.nextBoolean()) {
                    input[i][j] *= -1;
                }
            }
        }

        int[][] expected = Arrays.stream(input).map(int[]::clone).toArray(int[][]::new);
        int randomShift = r.nextInt(5) + 1;
        for (int cnt = 0; cnt < Math.log(m*n)/4 + randomShift; ++cnt) {
            int targetX = r.nextInt(m);
            int targetY = r.nextInt(n);
            input[targetX][targetY] = 0;

            //set expected column to zero
            for (int i = 0; i < m; ++i) {
                expected[i][targetY] = 0;
            }
            //set expected row to zero
            for (int j = 0; j < n; ++j) {
                expected[targetX][j] = 0;
            }
        }

        s.setZeroes(input);
        assertThat(input).isEqualTo(expected);
    }
}
