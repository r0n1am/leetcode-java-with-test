package q980;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2Test {

    static Solution2 s = new Solution2();

    @Test
    void shouldReturnOneForSimpleCase() {
        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 1},
            {2, 0, 0}
        })).isOne();
    }

    @Test
    void shouldReturnZeroForSimpleCase() {
        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 1},
            {2, 0, 0},
            {0, 0, 0}
        })).isZero();
    }

    @Test
    void shouldReturnOneForSimpleCaseWithObstacle() {
        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 1},
            {2, 0, 0},
            {-1, 0, 0}
        })).isOne();
    }

    @Test
    void shouldReturnOneForIrregularCaseWithObstacle() {
        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 1},
            {0, 0, 0},
            {2, -1}
        })).isOne();
    }

    @Test
    void shouldReturnZeroForIrregularCaseWithObstacle() {
        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 1},
            {2, 0, 0},
            {-1, 0}
        })).isZero();
    }

    @Test
    void shouldReturnCorrectResultForSampleCases() {
        assertThat(s.uniquePathsIII(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
        })).isEqualTo(4);

        assertThat(s.uniquePathsIII(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        })).isEqualTo(2);

        assertThat(s.uniquePathsIII(new int[][]{
            {0, 1},
            {2, 0}
        })).isZero();
    }


    @Test
    void shouldReturnCorrectResultForLargeArrays() {
        assertThat(s.uniquePathsIII(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
        })).isEqualTo(20);

        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
        })).isEqualTo(15);

        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
        })).isZero();

        assertThat(s.uniquePathsIII(new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 2}
        })).isZero();
    }
}
