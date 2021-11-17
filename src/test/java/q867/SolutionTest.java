package q867;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import util.RandomHelper;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    static Solution s = new Solution();
    static Random r = new Random();
    static RandomHelper randomHelper = new RandomHelper(r);

    @Test
    void shouldReturnCorrectResultForSimpleMatrix() {
        int[][] input = new int[][]{
            {1}
        };
        compareInputToTranspose(input, s.transpose(input));

        input = new int[][]{
            {1},
            {2}
        };
        compareInputToTranspose(input, s.transpose(input));

        input = new int[][]{
            {4, 17}
        };
        compareInputToTranspose(input, s.transpose(input));
    }

    @Test
    void shouldReturnCorrectResultForSampleMatrix() {
        int[][] input = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        compareInputToTranspose(input, s.transpose(input));

        input = new int[][]{
            {1, 2, 3},
            {4, 5, 6}
        };
        compareInputToTranspose(input, s.transpose(input));
    }

    @RepeatedTest(50)
    void shouldReturnCorrectResultForRandomMatrix() {
        int rowSize = r.nextInt(1000) + 1;
        int columnSize = randomHelper.keepRandomIf(1, 1000, n -> rowSize * n > 100_000);
        int[][] input = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < columnSize; ++j) {
                int value = r.nextInt(2_000_000_001) - 1_000_000_000;
                input[i][j] = value;
            }
        }
        compareInputToTranspose(input, s.transpose(input));
    }

    private void compareInputToTranspose(int[][] input, int[][] transpose) {
        for (int i = 0; i < transpose.length; ++i) {
            int[] row = transpose[i];
            assertThat(row).hasSize(input.length);
            for (int j = 0; j < row.length; ++j) {
                assertThat(row[j]).isEqualTo(input[j][i]);
            }
        }
    }
}
