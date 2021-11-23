package q724;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnZeroForSingleElementArray() {
        assertThat(s.pivotIndex(new int[]{1})).isZero();
    }

    @Test
    void shouldReturnZeroForSimpleArray() {
        assertThat(s.pivotIndex(new int[]{1, 0})).isZero();
    }

    @Test
    void shouldReturnCorrectResultsForSampleArrays() {
        assertThat(s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})).isEqualTo(3);

        assertThat(s.pivotIndex(new int[]{1, 2, 3})).isEqualTo(-1);

        assertThat(s.pivotIndex(new int[]{2, 1, -1})).isZero();
    }
}
