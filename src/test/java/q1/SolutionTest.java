package q1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectResult() {
        int[] numbers = new int[]{2, 7, 11, 15};
        assertThat(s.twoSum(numbers, 9))
            .containsExactlyInAnyOrder(0, 1);
    }
}
