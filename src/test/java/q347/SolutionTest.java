package q347;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectResultWithTwoElementsArray() {
        int[] nums = {1, 2};
        assertThat(s.topKFrequent(nums, 2))
            .containsExactlyInAnyOrder(nums);
    }

    @Test
    void shouldReturnCorrectResultsWithSampleTestCases() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        assertThat(s.topKFrequent(nums, 2))
            .containsExactlyInAnyOrder(new int[]{1, 2});

        nums = new int[]{1};
        assertThat(s.topKFrequent(nums, 1))
            .containsExactlyInAnyOrder(nums);
    }
}
