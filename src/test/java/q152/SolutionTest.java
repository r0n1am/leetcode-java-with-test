package q152;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectResultForSampleTests() {
        assertThat(s.maxProduct(new int[]{2, 3, -2, 4}))
            .isEqualTo(6);
        assertThat(s.maxProduct(new int[]{-2, 0, -1}))
            .isZero();
    }
}
