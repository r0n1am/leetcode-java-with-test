package q56;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectResultWithFailedCase1() {
        assertThat(
            s.merge(new int[][]{
                {1,4},
                {2,3}
            })
        )
        .isEqualTo(new int[][]{{1,4}});

    }

    @Test
    void shouldReturnCorrectResultWithSampleCases() {
        assertThat(
            s.merge(new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
            })
        )
        .isEqualTo(new int[][]{{1,6},{8,10},{15,18}});

        assertThat(
            s.merge(new int[][]{
                {1,4},
                {4,5}
            })
        )
        .isEqualTo(new int[][]{{1,5}});
    }
}
